package prac;

import java.util.Stack;

public class LinkedListCopy {
	public static class LLNode {
		int data;
		LLNode next;
		LLNode random;
		
		public LLNode(int d)
		{
			this.data = d;
		}
	}
	
	public static void main(String[] args) {
		LLNode l1 = new LLNode(1);		
		LLNode l2 = new LLNode(2);
		LLNode l3 = new LLNode(3);
		LLNode l4 = new LLNode(4);
		
		
		l1.next=l2;
		l1.random=l3;
		
		l2.next=l3;
		l2.random=l4;
		l3.next=l4;
		l4.random=l4;
		
		/*st.push(l1);
		copy();*/
		display(l1);
		swapPairs(l1);
		display(l1);
	}

	
	private static void display(LLNode l) {
		System.out.println();
		LLNode l1=l;
		while(l1!=null)
		{
			System.out.print(l1.data + " ");
			l1=l1.next;
		}
		
	}


	public static LLNode swapPairs(LLNode head) {
        if ((head == null)||(head.next == null))
            return head;
        LLNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
	static LLNode newHead;
	static Stack<LLNode> st;
	private static void copy() {
		// TODO Auto-generated method stub
		while(!st.isEmpty())
		{
			
		}
	}

}
