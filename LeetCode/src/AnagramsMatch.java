import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 * @author santh
 *
 */
public class AnagramsMatch {
	public static void main(String[] args) {
		System.out.println(isAnagram("aacc", "ccac"));
	}
	public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(hm1.containsKey(c))
            {
              int t1=hm1.get(c)+1;
              hm1.put(c,t1);
            }
            else
            {
                hm1.put(c,1);
            }
            
            char c1=t.charAt(i);
            if(hm2.containsKey(c1))
            {
              int t1=hm2.get(c1)+1;
              hm2.put(c1,t1);
            }
            else
            {
                hm2.put(c1,1);
            }
        }
        Iterator it= hm1.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry me=(Map.Entry)it.next();
        	char cc=(char) me.getKey();
        	int ii=(int)me.getValue();
        	if(!hm2.containsKey(cc))
        		return false;
        	
        	if(hm2.get(cc)!=ii)
        		return false;
        }
        for(Character c:hm1.keySet())
        {
            if(!hm2.containsKey(c))
                return false;
            
            if(hm2.get(c)!=hm1.get(c))
                return false;
        }
        return true;
    }
}
