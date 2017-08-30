package prac;

public class Caching {
public static void main(String[] args) {
	LFUCache lfu = new LFUCache(2);
	lfu.set(1, 10);
	lfu.set(2, 20);
	System.out.println(lfu.get(2));
	System.out.println(lfu.get(1));
	lfu.set(2,30);
	lfu.set(4, 40);
	System.out.println(lfu.get(1));
}
}
