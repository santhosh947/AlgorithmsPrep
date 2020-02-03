package Practice_Nov_2019;

import java.util.*;

class L146LRUCache {
    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);

        c.put(2,1);

        c.put(1,1);
        c.put(2,3);
        c.put(4,1);

        System.out.println(c.get(1));
        System.out.println(c.get(2));

    }

    private static class LRUCache {

        Map<Integer, Integer> hm = new HashMap();
       // Stack<Integer> st  = new Stack();
        Queue<Integer> qu  = new LinkedList();

        int size;
        public LRUCache(int capacity) {
            size = capacity;
            hm = new HashMap();
            qu = new LinkedList();
        }
        
        public int get(int key) {
            if(hm.containsKey(key))
            {
                int ele = hm.get(key);
              //  st.removeElement(key);
              //  st.add(key);

                qu.remove(key);
                qu.add(key);
                return ele;
            }
            return -1;            
        }
        
        // public void put_old(int key, int value) {
        //     if(st.size()>=size)
        //     {
        //         hm.remove(st.elementAt(0));

        //         st.removeElementAt(0);
        //     }
        //     st.add(key);
        //     hm.put(key,value);
            
        // }

        public void put(int key, int value) {
            if(hm.containsKey(key))
            {
               // hm.put(key, value);
                //qu.offer(key);
                qu.remove(key);
               // qu.add(key);
            }
            else if(qu.size()>=size)
            {
                hm.remove(qu.peek());
                qu.poll();
            }
            qu.add(key);
            hm.put(key,value);
            
        }
    }
}