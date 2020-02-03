package Practice_Nov_2019.HashTables;

import java.util.*;

class L516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("agbdba"));
        System.out.println(longestPalindromeSubseq("cbbd"));
        System.out.println(longestPalindromeSubseq("aaa"));

    }

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for(int i = 0;i < len;i++) 
        {
            dp[i][i] = 1;
        }

        for(int diff = 1;diff<len;diff++) 
        {
            for(int i=0;i<len-diff;i++)
            {      
                int j=i+diff;      
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }            
        }
        return dp[0][len-1];
    }

    private static int maxl;
    public static int longestPalindromeSubseq3(String s) {
        if(s==null) return 0;
        if(s.length()<2) return s.length();

        maxl=0;
        for(int i=0;i<s.length();i++)
        {
            extend(s,i,i+1);
            extend(s,i,i);

        }

        return maxl;
            
    }

    private static void extend(String s, int i, int j)
    {
        int localmax=j-i-1;
        while(i>=0 && i<s.length() && j>=0 && j<s.length() && localmax<s.length()-1 && s.charAt(i)==s.charAt(j))
        {
            i--;
            if(i<0)
                i=s.length()-1;
            j++;
            if(j>=s.length())
                j=0;
            localmax+=2;
        }
       maxl=Math.max(maxl, localmax);
    }

    public static int longestPalindromeSubseq2(String s) {
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