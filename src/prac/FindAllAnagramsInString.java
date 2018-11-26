package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public static void main(String[] args) {

		List<Integer> res = findAnagrams2("acbaab", "ab");
		for(int i: res)
		{
			System.out.println(i);
		}
	}
	
	public static List<Integer> findAnagrams2(String s, String p) {
		List<Integer> res= new ArrayList<Integer>();

		int len=p.length();
		char[] p_ch=p.toCharArray();
		Arrays.sort(p_ch);
		p=new String(p_ch);

		for(int i=0;i<s.length()-len+1;i++)
		{
			    int j=i+len;
				char[] chArr = s.substring(i,j).toCharArray();
				Arrays.sort(chArr);
				String t=new String(chArr);
				if(t.equals(p))
				{
					res.add(i);
				}		
		}
		return res;
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res= new ArrayList<Integer>();

		int len=p.length();
		char[] p_ch=p.toCharArray();
		Arrays.sort(p_ch);
		p=new String(p_ch);

		Map<Character, Boolean> hm = new HashMap<Character, Boolean>();
		for(int i=0;i<p.length();i++)
		{
			if(!hm.containsKey(p.charAt(i)))
			{
				hm.put(p.charAt(i),true);
			}

		}
		for(int i=0;i<s.length()-len+1;i++)
		{
			if(hm.containsKey(s.charAt(i)))
			{
			    int j=i+len;
				char[] chArr = s.substring(i,j).toCharArray();
				Arrays.sort(chArr);
				String t = new String(chArr);
				if(t.equals(p))
				{
					res.add(i);
				}
			}	
		}
		return res;
	}
	
	
	public static List<Integer> findAnagramsLeetCD(String s, String p) {
	    int[] chars = new int[26];
	    List<Integer> result = new ArrayList<>();

	    if (s == null || p == null || s.length() < p.length())
	        return result;
	    for (char c : p.toCharArray())
	        chars[c-'a']++;

	    int start = 0, end = 0, count = p.length();
	    // Go over the string
	    while (end < s.length()) {
	        // If the char at start appeared in p, we increase count
	        if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
	            count++;
	        // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
	        if (--chars[s.charAt(end++)-'a'] >= 0)
	            count--;
	        if (count == 0)
	            result.add(start);
	    }
	    
	    return result;
	}

}
