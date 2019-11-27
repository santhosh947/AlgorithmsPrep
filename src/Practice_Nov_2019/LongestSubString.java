package Practice_Nov_2019;

import java.util.*;

/**
 * Input: "abcabcbb" Output: 3
 * 
 * Input: "bbbbb" Output: 1
 * 
 * Input: "pwwkew" Output: 3
 **/
public class LongestSubString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring_1(String s) {
		int res = 0;
		if(s== null )
			return res;
		
		if(s.length() == 1)
			return 1;
		HashSet<Character> hm = new HashSet<Character>();
		int ctr = 0;
		
		for(int i=0; i< s.length()-1; i++)
		{
			hm = new HashSet<Character>();
			
			hm.add(s.charAt(i));
			ctr=1;
			for(int j=i+1;j<s.length();j++)
			{
				if(hm.contains(s.charAt(j)))
					break;
				else
					hm.add(s.charAt(j));
				
				ctr++;
			}
			if(ctr > res)
				res= ctr;
		}
				
		return res;
	}
	
	public static int lengthOfLongestSubstring(String str)
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

}