import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * @author santh
 *
 */
public class FindAllAnagramsInAString {
	
	public static void main(String[] args) {
		List<Integer> res=findAnagrams_LeetCode("cbaebabacd", "abc");
		for(int i:res)
		{
			System.out.println(i);
		}
	}
	
	public static List<Integer> findAnagrams_LeetCode(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) 
	    	return list;
	    
	    
	    int[] hash = new int[256]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return list;
	}
	
	/**
	 * this method is failing with time limit exceeded error in leetcode
	 * @param s
	 * @param p
	 * @return
	 */
	 public static List<Integer> findAnagrams(String s, String p) {
			List<Integer> res= new ArrayList<Integer>();
		    if(s.length()<p.length())
		        return res;
		        
		    
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

	
}
