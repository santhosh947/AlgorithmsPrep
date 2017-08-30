package prac;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	//Key -> Val
    HashMap<Integer, Integer> vals;
    
    //Holds Keys and its count number of time used
    HashMap<Integer, Integer> counts;
    
    //Holds counts and the respective keys in the form of linked list
    //ex count 1: key1->key2 , count 2: key3->key4
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<Integer>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void set(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
