package Prac2;

import java.util.Stack;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}


public class AddTwoNumbersLinkedList {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(7);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		ListNode a4 = new ListNode(3);
		
		/*a1.next=a2;
		a2.next = a3;
		a3.next=a4;*/
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		
		/*b1.next=b2;
		b2.next = b3;*/
		
		ListNode s = addTwoNumbers(a1, b1);
		System.out.println();
		while(s!=null)
		{
			System.out.print(s.val+"->");
			s=s.next;
		}
		System.out.println();
	}
	
public static ListNode addTwoNumbers(ListNode a1, ListNode b1) {
	int len1 = findLen(a1);
	int len2 = findLen(b1);
	ListNode s=null;
	Stack<Integer> st = new Stack<Integer>();
	st.add(0);
	if(len1==len2)
	{
	  s = addTwoLL(a1, b1, st);
	}
	else if(len1>len2)
	{
		ListNode nb1 = Patch(b1, len1-len2);
		s = addTwoLL(a1,nb1,st);
	}
	else
	{
		ListNode na1 = Patch(a1, len2-len1);
		s = addTwoLL(na1, b1,st);
	}
	if(!st.isEmpty() && st.peek()!=0)
	{
		ListNode tt = new ListNode(st.pop());
		tt.next=s;
		return tt;
	}
	return s;
        
    }
	
	private static ListNode Patch(ListNode b1, int diff) {
		ListNode patchHead = new ListNode(0);
		ListNode pt = patchHead;
		while(diff>1)
		{
			pt.next = new ListNode(0);
			pt=pt.next;
			diff--;
		}
		pt.next=b1;
		return patchHead;
	}

	private static int findLen(ListNode a1) {
		int len =0;
		ListNode ll = a1;
		while(ll!=null)
		{
			len++;
			ll=ll.next;
		}
		return len;
	}

	public static ListNode addTwoLL(ListNode l1, ListNode l2, Stack<Integer> st)
	{
		if(l1 ==null && l2==null)
			return null;
		

		int carry = 0;

		ListNode nd = new ListNode(0);
		
		nd.next = addTwoLL((l1!=null ? l1.next : null),(l2!=null ? l2.next : null),st);
		
		int sum = (l1==null ? 0 : l1.val) + (l2==null ? 0 :l2.val)+st.pop();		
		
		if(sum>=10)
		{
			carry=1;
			st.add(carry);
			sum=sum%10;
		}
		else
		{
			st.add(0);
		}
				
		nd.val=sum;
		return nd;
	}
}
