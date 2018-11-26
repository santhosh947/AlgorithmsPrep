package prac;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDt722P1_findLongestChain {
	public static void main(String[] args) {
		/*
		 * int[] a={1,2,2,4}; int[] aa= findErrorNums(a); for(int i: aa) {
		 * System.out.println(i); }
		 */
		// System.out.println(countSubstrings("aba"));

		int[][] a = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		int[][] b = { { 3,4 }, { 2, 3 }, { 1,2 } };
		//[[3,4],[2,3],[1,2]]
		int[][] c={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };

		System.out.println(findLongestChain(c));
	}

	public static int findLongestChain(int[][] pairs) {
		int ct = 0;
		int max = 0;
		int len = pairs.length;

		for (int i = 0; i < len - 1; i++) {
			max = 0;
			int a = i;
			//if (ct < len - i) {
				for (int j = 0; j < len;) {
					if(i==j)
					{
						j++;
						break;
					}
						
					// System.out.println("Comparing " + pairs[j][0] + " " +
					// pairs[a][1]);
					if (pairs[j][0] > pairs[a][1]) {
						a = j;
						max++;
					}
					j++;
				//}
			}
			if (max > ct)
				ct = max;
		}
		if (max > ct)
			ct = max;
		return ct+1;

	}

	public static int[] findErrorNums(int[] nums) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] temp = new int[nums.length];
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (temp[nums[i] - 1] == 1) {
				res[0] = nums[i];
			}
			temp[nums[i] - 1]++;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0)
				res[1] = i + 1;
		}
		return res;
	}

	public static int countSubstrings(String s) {

		int ct = 0;
		int len = s.length();
		if (len == 0 || len == 1)
			return len;
		for (int l = 1; l < len + 1; l++) {
			for (int i = 0; i + l < len + 1; i++) {
				String subStr = s.substring(i, i + l).toLowerCase();
				if (isPalin(subStr)) {
					ct++;
				}
			}
		}
		return ct;
	}

	public static boolean isPalin(String s) {
		int l = s.length() - 1;
		int st = 0;
		while (st < l) {
			if (s.charAt(st) != s.charAt(l))
				return false;

			st++;
			l--;
		}
		return true;
	}
}
