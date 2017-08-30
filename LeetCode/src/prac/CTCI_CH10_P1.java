package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CTCI_CH10_P1 {
	public static void main(String[] args) {
		int[] a = new int[6];
		a[0] = 4;
		a[1] = 5;
		a[2] = 6;
		int[] b = { 1, 2, 3 };
		// merge(a, b, 3, 3);

		/*
		 * int[] a=new int[1]; a[0]=1; int[] b={}; merge(a,b,1,0);
		 */
		/*
		 * for (int i : a) { System.out.println(i); }
		 */
		// System.out.println(isAnagram("aacc","ccac"));

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		/*
		 * List<List<String>> res = groupAnagrams(strs); for (int i = 0; i <
		 * res.size(); i++) { for (int j = 0; j < res.get(i).size(); j++) {
		 * System.out.print(res.get(i).get(j) + " "); } System.out.println(); }
		 */

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int[] n={5,1,3};
		
		System.out.println(search(nums, 1));
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, String> hm = new HashMap<>();
		for (String s : strs) {

		}
		return res;
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Queue<String> holder = new LinkedList<String>();
		List<List<String>> res = new ArrayList<>();
		List<String> angLists = new ArrayList<String>();
		for (String s : strs) {
			holder.add(s);
		}
		holder.add(null);
		String firstStr = "";
		if (!holder.isEmpty())
			firstStr = holder.poll();
		ArrayList<String> ang = new ArrayList<String>();
		ang.add(firstStr);
		while (!holder.isEmpty()) {
			String head = holder.poll();
			if (head == null) {
				holder.add(null);
				if (ang.size() > 0) {
					res.add(ang);
				}
				ang = new ArrayList<String>();
				if (!holder.isEmpty()) {
					firstStr = holder.poll();
					if (firstStr != null)
						ang.add(firstStr);
				}
			} else {
				if (checkAnagram(firstStr, head))
					ang.add(head);
				else
					holder.add(head);
			}
		}
		return res;
	}

	public static boolean checkAnagram(String s, String t) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		String s_new = new String(ch);
		ch = t.toCharArray();
		Arrays.sort(ch);
		String t_new = new String(ch);
		return t_new.equals(s_new);
	}
	
	public static int search(int[] nums, int target) {
		int pv = findPvt(nums,0,nums.length-1);
		//System.out.println(pv);
		if(pv>0 && nums[0]<=target)
			return BinarySearch(nums, 0, pv, target);
		else if(pv<nums.length-1 && nums[pv]<=target)
			return BinarySearch(nums, pv, nums.length, target);
		return -1;
		
	}
	private static int BinarySearch(int[] inp, int lo, int hi, int k) {

		int mid = (lo+hi)/2;
		if(lo==hi && inp[mid]!=k)
		{
			return -1;
		}
		
		if(inp[mid]==k)
		{
			return mid;
		}
		else if(inp[mid]>k &&mid>0)
		{
			return BinarySearch(inp, lo, mid-1, k);
		}
		else if(inp[mid]<k)
		{
			return BinarySearch(inp, mid+1, hi, k);
		}
		
		return -1;
	}

	private static int findPvt(int[] nums, int i, int j) {
		if(j-i==1)
		{
			if(nums[j]<nums[i])
				return j;
		}
		int mid = (i+j)/2;
		if(nums[mid]>nums[j])
		{
			findPvt(nums, mid, j);
		}
		else
		{
			findPvt(nums, i, mid);
		}
		
		return mid;
	}

	public static int search2(int[] nums, int target) {
		int i = 0;
		int j = nums.length-1;
		while (i <= j) {
			int mid = (i+j)/ 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				//if (nums[i] >= target && nums[mid-1]>=target)
				if(nums[i]<=target)
					j = mid - 1;
				else
					i = mid + 1;
			} else {
				if (nums[j] <= target)
					i = mid + 1;
				else
					j = mid - 1;
			}
		}
		return -1;
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hm1.get(s.charAt(i)) != null) {
				int temp = hm1.get(s.charAt(i));
				hm1.put(s.charAt(i), ++temp);
			} else
				hm1.put(s.charAt(i), 1);
		}

		Map<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hm2.get(t.charAt(i)) != null) {
				int temp = hm2.get(t.charAt(i));
				hm2.put(t.charAt(i), ++temp);
			}
			// hm2.put(t.charAt(i), hm1.get(t.charAt(i))++);
			else
				hm2.put(t.charAt(i), 1);
		}

		Iterator it = hm1.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			int val = (int) me.getValue();
			char ch = (char) me.getKey();
			if (hm2.get(ch) == null || hm2.get(ch) != val)
				return false;

		}
		return true;
	}

	static void merge(int[] A, int[] B, int lastA, int lastB) {
		int b_st = 0;
		int b_l = lastB - 1;
		int a_st = 0;
		int a_l = lastA - 1;
		int a_len = A.length - 1;

		while (b_l >= 0 && a_l >= 0) {
			if (B[b_l] > A[a_l]) {
				A[a_len] = B[b_l];
				b_l--;
			} else {
				A[a_len] = A[a_l];
				a_l--;
			}
			a_len--;
		}

		while (b_l >= 0) {
			A[a_len] = B[b_l];
			b_l--;
			a_len--;
		}
	}
}
