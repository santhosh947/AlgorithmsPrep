package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode {
	public int findLUSlength(String[] strs) {
        int N = strs.length;
        Map<String, Integer> cnt = new HashMap<>();
        for(String s : strs) {
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        List<String> duplicates = new ArrayList<>();
        List<String> uniques = new ArrayList<>();
        for(String s : strs) {
            if(cnt.get(s) > 1) duplicates.add(s);
            else uniques.add(s);
        }
        /*Collections.sort(uniques, (s1, s2) -> s2.length() - s1.length());
        for(int i = 0; i < uniques.size(); i++) {
            String s = uniques.get(i);
            if(check(s, duplicates) || check(s, uniques.subList(0, i))) continue;
            return s.length();
        }*/
        return -1;
    }
    
    private boolean check(String s, List<String> l) {
        for(String x : l) {
            if(subs(s, x)) return true;
        }
        return false;
    }
    
    private boolean subs(String s, String x) {
        int i = 0, M = s.length(), j = 0, N = x.length();
        while(i < M && j < N) {
            if(s.charAt(i) == x.charAt(j)) i++;
            j++;
        }
        return i == M;
    }
}
