package Prc_2020_Q4;

public class L242ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s != null && t != null && s.length() != t.length())
            return false;
        int[] mapping = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mapping[c - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapping[c - 'a'] -= 1;

        }
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] != 0)
                return false;
        }
        return true;
    }
}
