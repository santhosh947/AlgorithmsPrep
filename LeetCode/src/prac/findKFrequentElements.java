package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class findKFrequentElements {
	public static void main(String[] args) {
		System.out.println(frequencySort("aaddbbccc"));
		/*List<Character> ch = new ArrayList<>();
		ch.add('c');
		ch.add('a');
		ch.add('b');
		for(char cc:ch)
		{
			System.out.println(cc);
		}*/
		
		Map<Character, Integer> ch = new HashMap<>();
		ch.put('2',1);
		ch.put('1',2);
		ch.put('3',3);
		for(char cc:ch.keySet())
		{
			System.out.println(cc);
		}
		
		Map<Character, Integer> ch1 = new TreeMap<>();
		ch1.put('2',1);
		ch1.put('5',2);
		ch1.put('1',3);
		for(char cc:ch1.keySet())
		{
			System.out.println(cc);
		}
	}
	
	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}
