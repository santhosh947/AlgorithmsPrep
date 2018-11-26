package Prac2;

import java.util.HashMap;

public class twoSum {
	public static void main(String[] args) {
		int[] sums = { 3,3 };
		int tar = 6;
		int[] res = findPair(sums, tar);
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
}
