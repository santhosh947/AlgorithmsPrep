package Prac2;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListEx {
	public static class Llist{
		int val;
		Llist next = null;
		
		public Llist(int v)
		{
			this.val=v;
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		//al.add('a');
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		hm.put(1, 1);
		hm.put(2, 20);
		for(int i=0;i<hm.size();i++)
		{
			if(hm.containsKey(1))
				System.out.println(hm.get(1));
			
			if(hm.containsValue(20))
				System.out.println(hm.get(2));
		}
		
		Llist l1= new Llist(1);
		Llist l2 = new Llist(2);
		Llist l3 = new Llist(3);
		Llist l4 = new Llist(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		Llist temp = l1;
		while(temp!=null)
		{
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		Llist head = l1;
		Llist prev = l1;
		Llist curr = prev;
		int f = 4;
		while(curr!=null)
		{
			if(curr.val == f)
			{
				if(prev == head && curr == prev)
				{
					head = prev.next;
				}
				else
				{
					prev.next = curr.next;
				}
				break;
			}
			else
			{
				if(prev == curr)
				{
					curr = curr.next;
				}
				else
				{
					prev = prev.next;
					curr = curr.next;
				}
			}
		}
		
		System.out.println();
		Llist t2 = head;
		while(t2!=null)
		{
			System.out.print(t2.val + "->");
			t2 = t2.next;
		}
		
		
	}
}
