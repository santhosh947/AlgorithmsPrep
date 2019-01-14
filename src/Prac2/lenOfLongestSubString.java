package Prac2;

import java.util.HashMap;
import java.util.Map;

public class lenOfLongestSubString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("accba"));
	}
	
	public static int lengthOfLongestSubstring(String str) {
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
}
