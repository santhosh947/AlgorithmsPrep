package Prac2;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU implements Cache {
	public int size = 0;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, Integer> vals;
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	int min = -1;

	public LFU(int capacity) {
		size = capacity;
		counts = new HashMap<Integer, Integer>();
		vals = new HashMap<Integer, Integer>();
		lists = new HashMap<Integer, LinkedHashSet<Integer>>();
		min=1;
	}

	@Override
	public int get(int key) {
		if(!vals.containsKey(key))
			return -1;
		
		int c = counts.get(key);
		counts.put(key, c+1);
		
		lists.get(c).remove(key);
		if(min == c && lists.get(min).size() ==0)
		{
			min++;
		}
		
		if(!lists.containsKey(c+1)){
			LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
			lists.put(c+1, hs);
		}
		lists.get(c+1).add(key);
		
		return vals.get(key);
	}

	@Override
	public void put(int key, int value) {
		if (size <= 0)
			return;
		if (vals.containsKey(key)) {
			vals.put(key, value);
			get(key);
			return;
		}
		if (vals.size() >= size) {
			int e = lists.get(min).iterator().next();
			vals.remove(e);
			counts.remove(e);
			lists.get(min).remove(e);
			if(lists.get(min).size() ==0)
				min++;
		}
		vals.put(key, value);
		counts.put(key, 1);
		if(!lists.containsKey(1))
		{
			LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
			lists.put(1, hs);
		}
		lists.get(1).add(key);
	}

}
