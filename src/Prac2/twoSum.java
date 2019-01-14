package Prac2;

import java.util.HashMap;

public class twoSum {
	public static void main(String[] args) {
		int[] sums = { 1,2,4,4 };
		int tar = 8;
		int[] res = findPair3(sums, tar);
		System.out.print(res[0] + " " + res[1]);
	}

	public static int[] findPair(int[] s, int t) {
		HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < s.length; i++) {
			ht.put(t - s[i], i);
		}
		for (int i = 0; i < s.length; i++) {
			if (ht.containsKey(s[i]) && ht.get(s[i])!=i) {
				res[1] = i;
				res[0] = ht.get(s[i]);
				break;
			}
		}

		return res;
	}
	
	public static int[] findPair3(int[] s, int t) {
		HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
		int[] res = new int[2];		
		for (int i = 0; i < s.length; i++) {
			if (ht.containsKey(s[i]) && ht.get(s[i])!=i) {
				res[1] = i;
				res[0] = ht.get(s[i]);
				break;
			}
			else
			{
				ht.put(t - s[i], i);
			}
		}

		return res;
	}
	
	public static int[] findPair2(int[] s, int t)
	{
		int[] res = new int[2];
		for(int i=0, j= s.length-1;i!=j && i<s.length && j>=0;)
		{
			if(s[i]+s[j]==t)
			{
				res[0]=i;
				res[1]=j;
				return res;
			}
			else if(s[i]+s[j]>t)
			{
				j--;
			}
			else
			{
				i++;
			}				
		}
		return res;
	}
} 
