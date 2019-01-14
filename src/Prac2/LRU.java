package Prac2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRU implements Cache {

	int size;
	HashMap<Integer, Integer> vals;
	HashMap<Integer, Integer> counts;
	Queue<Integer> q;
	
	public LRU(int capacity)
	{
		size = capacity;
		vals = new HashMap<>();
		counts = new HashMap<>();
		q = new LinkedList<>();
	}
	
	@Override
	public int get(int key) {
		
		if(!vals.containsKey(key))
			return -1;
		
		int cc = counts.get(key);
		counts.put(key, cc+1);
		
		q.add(key);
		
		return vals.get(key);
	}

	@Override
	public void put(int key, int value) {
		if(size <= 0)
			return;
		
		if(vals.size() >= size)
		{
			int evit = findEvit();
			counts.remove(evit);
			vals.remove(evit);			
		}
		counts.put(key, 1);
		vals.put(key, value);
		q.add(key);
		
	}

	private int findEvit() {
		while(q.size()>0)
		{
			int ev = q.poll();
			if(counts.get(ev) == 1)
			{
				return ev;
			}
			else
			{
				int cc = counts.get(ev);
				counts.put(ev, cc-1);
			}
		}
		return -1;
	}
}
