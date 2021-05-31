package Prc_2020_Q4;

import java.util.*;

public class L76MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < 1 || t.length() < 1 || t.length() > s.length()) {
            return "";
        }
        int count = t.length();
        String res = s;

        Map<Character, Integer> mapper = new HashMap();
        Map<Character, Integer> validator = new HashMap();
        Map<Character, Integer> tracker = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            mapper.put(t.charAt(i), mapper.getOrDefault(t.charAt(i), 0) + 1);
            validator.put(t.charAt(i), validator.getOrDefault(t.charAt(i), 0) + 1);
        }

        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mapper.containsKey(c)) {
                if (mapper.get(c) > 0) {
                    count--;
                }
                mapper.put(c, mapper.get(c) - 1);
                tracker.put(c, tracker.getOrDefault(c, 0) + 1);
            }

            while (p1 <= p2 && p2 < s.length()) {
                char local_ch = s.charAt(p1);
                if ((!tracker.containsKey(local_ch))) {
                    p1++;
                } else if ((tracker.get(local_ch) > validator.get(local_ch))) {
                    tracker.put(local_ch, tracker.get(local_ch) - 1);
                    p1++;
                } else {
                    break;
                }
            }
            if (count <= 0 && res.length() > (p2 - p1 + 1)) {
                res = s.substring(p1, p2 + 1);
            }
            p2++;
        }

        if (count > 0)
            return "";
        else {
            if (res.length() > (p2 - p1)) {
                res = s.substring(p1, p2);
            }
            return res;
        }

    }

}
