package Prac2;

import java.util.HashSet;

public class LongestSubStringWithKUniqueChar {
	public static void main(String[] args) {
		String str = "aabcdef";
		System.out.println(longestUniqueSubString(str, 3));		
	}
	
	public static String longestUniqueSubString(String str, int k)
	{
		if(str == null)
			return str;
		
		if(str.length() <= k)
			return str;
		
		int[] op = new int[2];
		HashSet<Character> hs = new HashSet<Character>();
		
		for(int i=0;i<str.length()-k-1;i++)
		{
			hs = new HashSet<Character>();
			hs.add(str.charAt(i));
			int res =1;
			for(int j=i+1; hs.size() <= k && j< str.length() ; j++)
			{
				if(!hs.contains(str.charAt(j)))
				{
					hs.add(str.charAt(j));
				}				
				res++;
			}
			if(hs.size() > k)
				res--;
			
			if(res > op[0])
			{
				op[0]=res;
				op[1]=i;
			}			
		}
		
		return str.substring(op[1],op[0]+op[1]);
	}
}
