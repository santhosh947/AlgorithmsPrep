package Prc_2020_Q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L49GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "ac", "c" };
        List<List<String>> res = groupAnagrams(strs);

        System.out.println("hello");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();

        HashMap<Set<Character>, List<String>> helper = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            boolean isAng = false;
            for (Map.Entry<Set<Character>, List<String>> set : helper.entrySet()) {
                Set<Character> hs = set.getKey();
                List<String> ang = set.getValue();
                isAng = true;

                if (word.length() != hs.size()) {
                    isAng = false;
                    break;
                }
                for (int k = 0; k < word.length(); k++) {
                    char c = word.charAt(k);
                    if (!hs.contains(c)) {
                        isAng = false;
                        break;
                    }
                }
                if (isAng) {
                    ang.add(word);
                    helper.put(hs, ang);
                    break;
                }

            }
            if (!isAng) {
                Set<Character> hs = new HashSet<Character>();
                List<String> ang = new ArrayList();
                for (int k = 0; k < word.length(); k++) {
                    char c = word.charAt(k);
                    hs.add(c);
                }

                ang.add(word);

                helper.put(hs, ang);

            }
        }
        for (Map.Entry<Set<Character>, List<String>> set : helper.entrySet()) {
            res.add(set.getValue());
        }
        return res;
    }

}
