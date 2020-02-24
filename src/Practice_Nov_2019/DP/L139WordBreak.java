package Practice_Nov_2019.DP;


import java.util.*;

class L139WordBreak {

    public static void main(String[] args) {
        String s = "leot";
        List<String> l = new ArrayList<>();
        l.add("le");
        l.add("ot");

        System.out.println(wordBreak2(s,l));
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                 memo[start] = true;
                 return true;
            }
        }
        memo[start] = false;
        return false;
    }

    
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> st = new HashSet<>();

        for(String w: wordDict)
        {
            st.add(w);
        }

        return binarySearch(s,0,s.length()-1,st);
       // return true;
    }

    private static boolean binarySearch(String s, int i, int j, Set<String> st) {

        if(i<0 || j>s.length() || s==null || i>j)
            return false;
        String wd = s.substring(i,j+1);
        if(st.contains(wd))
        {
            return true;
        }
        int mid = (i+j)/2;

        boolean left = binarySearch(s, i, mid, st);
        boolean right = binarySearch(s,mid+1,j,st);
        if(left && right)
        {
            return true;
        }
        else {
            boolean ll = binarySearch(s, i, mid+1, st) && binarySearch(s, mid+1, j, st);
            if(!ll)
            {
                return binarySearch(s, i, mid-1, st) && binarySearch(s, mid-1, j, st);
            }
        }
        return true;
    }
}