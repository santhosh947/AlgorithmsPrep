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

    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

}

// private static class LRUCache {

// Map<Integer, Integer> hm = new HashMap();
// // Stack<Integer> st = new Stack();
// Queue<Integer> qu = new LinkedList();

// int size;
// public LRUCache(int capacity) {
// size = capacity;
// hm = new HashMap();
// qu = new LinkedList();
// }

// public int get(int key) {
// if(hm.containsKey(key))
// {
// int ele = hm.get(key);
// // st.removeElement(key);
// // st.add(key);

// qu.remove(key);
// qu.add(key);
// return ele;
// }
// return -1;
// }

// // public void put_old(int key, int value) {
// // if(st.size()>=size)
// // {
// // hm.remove(st.elementAt(0));

// // st.removeElementAt(0);
// // }
// // st.add(key);
// // hm.put(key,value);

// // }

// public void put(int key, int value) {
// if(hm.containsKey(key))
// {
// // hm.put(key, value);
// //qu.offer(key);
// qu.remove(key);
// // qu.add(key);
// }
// else if(qu.size()>=size)
// {
// hm.remove(qu.peek());
// qu.poll();
// }
// qu.add(key);
// hm.put(key,value);

// }
// }
}