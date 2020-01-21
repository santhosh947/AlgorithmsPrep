import prac.ListNode;

public class LinkedListSwap {
public static void main(String[] args) {
	ListNode l1=new ListNode(1);
	ListNode l2=new ListNode(2);
	ListNode l3=new ListNode(3);
	ListNode l4=new ListNode(4);
	
	l1.next=l2;
	l2.next=l3;
	l3.next=l4;
	
	show(l1);
	ListNode r1=swapPairs2(l1);
	System.out.println();
	show(r1);
	
}

private static void show(ListNode l1) {

	while(l1!=null)
	{
		System.out.print(l1.val + " ");
		l1=l1.next;
	}
}

public static ListNode swapPairs(ListNode head) {
    if ((head == null)||(head.next == null))
        return head;
    ListNode n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
}

public static ListNode swapPairs2(ListNode head) {
    if ((head == null)||(head.next == null))
        return head;
	
	ListNode dum = new ListNode(0);
	ListNode curr = dum;
	dum.next = head;
	while(dum.next!=null && dum.next.next!=null)
	{
		ListNode f = dum.next;
		ListNode s = dum.next.next;

		f.next = s.next;
		s.next = f;
		dum.next = s;
		dum = dum.next.next;
	}
    
    return curr.next;
}
}
