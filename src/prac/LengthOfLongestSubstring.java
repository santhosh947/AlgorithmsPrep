package prac;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcaa"));
		System.out.println(findLongS("abcabcaa"));

	}
	

	public static int findLongS(String str)
	{
	    int len = str.length();
	    Map<Character, Integer> hm = new HashMap<Character,Integer>();
	    int res=0;
	    for(int i=0, j=0;i<len;i++)
	    {
	        if(hm.containsKey(str.charAt(i)))
	        {
	            j=Math.max(j,hm.get(str.charAt(i))+1);
	        }
	        hm.put(str.charAt(i), i);
	        res=Math.max(res, i-j+1);
	    }
	    return res;
	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
