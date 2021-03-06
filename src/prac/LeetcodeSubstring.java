package prac;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeSubstring {
	public static void main(String[] args) {
		// abcabcbb
		// dvdf
		// bbbbb
		StringBuilder st = new StringBuilder();
		System.out.println("abcabcbb " + lengthOfLongestSubstring2("abcabcbb"));
		// pwwkew
		System.out.println("pwwkew " + lengthOfLongestSubstring2("pwwkew"));
		System.out.println("dvdf " + lengthOfLongestSubstring2("dvdf"));

		System.out.println("bbbbb " + lengthOfLongestSubstring2("bbbbb"));

		System.out.println("au " + lengthOfLongestSubstring2("au"));

	}

	public static int lengthOfLongestSubstring2(String str) {
		HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
		int res = 0;
		int len = str.length();
		int st = 0;
		int max = 0;
		// String sss="";
		for (int a = 0; a < len; a++) {
			hm = new HashMap<>();
			if (res < len - a) {
				for (int i = a; i < len; i++) {
					String ch = String.valueOf(str.charAt(i)).toLowerCase();
					String t = str.substring(a, i + 1).toLowerCase();
					if ((hm.get(t) != null && hm.get(t))
							|| (hm.get(ch) != null && hm.get(ch))) {
						if (max > res) {
							res = max;
						}
						break;
					} else {
						if (ch.equals(t)) {
							hm.put(t, true);
							max=t.length();
						} else {
							hm.put(t, true);
							hm.put(ch, true);
							max = t.length();
						}
					}
				}
				if(max>res)
					res=max;
			}
		}
		if (max > res)
			res = max;
		return res;
	}

	public static int lengthOfLongestSubstring(String s) {
		int size = s.length();
		if (size == 0)
			return 0;
		if (size == 1)
			return 1;

		// int hf=0;
		int max = 0;
		int temp = 0;
		Map<Character, Boolean> hm = new HashMap<Character, Boolean>();
		for (int i = 0; i < size; i++) {
			if (hm.get(s.charAt(i)) != null && hm.get(s.charAt(i))) {
				if (temp > max) {
					max = temp;
					temp = 0;
				}
				// temp=0;
				// hm=new HashMap<>();
				// hm.put(s.charAt(i),true);
				// temp++;
			} else {
				max++;
				temp++;
				hm.put(s.charAt(i), true);
			}
		}
		if (temp > max)
			max = temp;
		return max;
	}
}