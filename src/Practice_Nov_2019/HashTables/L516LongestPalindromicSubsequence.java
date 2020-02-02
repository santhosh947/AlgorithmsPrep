package Practice_Nov_2019.HashTables;

import java.util.*;

class L516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public static int longestPalindromeSubseq(String s) {
        Map<Character, Integer> st_odd = new HashMap();
        Map<Character, Integer> st_even = new HashMap();

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(st_odd.containsKey(c))
            {
                st_even.put(c,st_odd.get(c)+1);

                st_odd.remove(c);
            }
            else if(st_even.containsKey(c))
            {
                st_odd.put(c,st_even.get(c)+1);
                st_even.remove(c);
            }
            else {
                st_odd.put(c,1);
            }
        }
        Iterator it = st_even.entrySet().iterator();
        int ct=0;
        while(it.hasNext())
        {
            Map.Entry me = (Map.Entry)it.next();
            ct+=(int)me.getValue();
        }
        
        it = st_odd.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry me = (Map.Entry)it.next();
            int v = (int)me.getValue();
            if(v==1)
            {
                ct+=(int)me.getValue();
                break;
            }
        }
       // return st_even.size()+(st_odd.size()>0?1:0);
        return ct;
    }
}