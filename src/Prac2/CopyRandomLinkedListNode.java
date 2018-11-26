package Prac2;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedListNode {
	public static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;
		
		public RandomListNode(int v)
		{
			this.label = v;
//			this.next = nt;
//			this.random = rd;		
		}
		
	}
	
	public static void main(String[] args)
	{
		RandomListNode l1 = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		l1.random = l4;
		l2.random = l1;
		l3.random = l2;
		l4.random = l2;
		
		show(l1);
		
		RandomListNode copiedVal = copyRandomList(l1);
		
		System.out.println("Copied values");
		show(copiedVal);
		
	}

	private static RandomListNode copyRandomList(RandomListNode l1) {
		Map<RandomListNode, RandomListNode> mp = new HashMap<RandomListNode, RandomListNode>();
		
		if(l1==null)
			return null;
		
		RandomListNode t2 = l1;
		RandomListNode res = new RandomListNode(t2.label);
		RandomListNode r1 = res;

		while(t2.next!=null)
		{
			RandomListNode r2= new RandomListNode(t2.next.label);
			r1.next = r2;
			r1=r1.next;
			t2=t2.next;
		}
		r1.next=null;
		
		RandomListNode temp = l1;
		RandomListNode rdPtr = res;
		while(temp != null && rdPtr!=null && !mp.containsKey(temp))
		{
			mp.put(temp, rdPtr);
			temp=temp.next;
			rdPtr = rdPtr.next;
		}
		
		RandomListNode orgRdptr = l1;
		RandomListNode copyRdptr= res;
		while(orgRdptr!=null && copyRdptr!=null)
		{
			copyRdptr.random = mp.containsKey(orgRdptr) ? mp.get(orgRdptr.random) : null;
			orgRdptr=orgRdptr.next;
			copyRdptr=copyRdptr.next;
		}	
		
		return res;
	}

	private static void show(RandomListNode l1) {

		RandomListNode temp = l1;
		RandomListNode t2 = l1;
		System.out.println("Showing the next nodes");
		while(temp!=null)
		{
			System.out.print(temp.label+"->");
			temp=temp.next;
		}
		System.out.println();
		System.out.println("Showing the random nodes");
		while(t2!=null)
		{
			System.out.print(t2.label+"->");
			System.out.println(t2.random.label+"->");
			t2=t2.next;
		}
		System.out.println();
	}
}
