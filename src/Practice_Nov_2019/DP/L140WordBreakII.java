package Practice_Nov_2019.DP;

import java.util.*;

import prac.WordBreak;
import prac.wordReverse;

class L140WordBreakII {
    public static void main(String[] args) {
        String s = "leot";
        List<String> l = new ArrayList<>();
        l.add("le");
        l.add("ot");
        List<String> res = wordBreak(s,l);
        for(String a: res)
        {
            System.out.println(a);
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    static HashMap<Integer, List<String>> map = new HashMap<>();

    public static List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}