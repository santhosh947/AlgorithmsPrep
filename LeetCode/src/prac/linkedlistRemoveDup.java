package prac;

public class linkedlistRemoveDup {
	public static void main(String[] args) {
		ListNode hd= new ListNode(15);
		ListNode n1=new ListNode(6);
		hd.next=n1;
		ListNode n2=new ListNode(7);
		n1.next=n2;
		ListNode n3=new ListNode(6);
		n2.next=n3;
		ListNode n4=new ListNode(15);
		n3.next=n4;
		ListNode n5=new ListNode(9);
		n4.next=n5;
		n5.next=null;
		
		display(hd);
		
		ListNode h=removeDup(hd);
		System.out.println();
		display(h);
	}

	private static ListNode removeDup(ListNode hd) {
		ListNode n=hd;
		ListNode ct=n.next;
		ListNode prev=n;
		ListNode pre_prev=n;
		while(n!=null)
		{
			ct=n.next;

			while(ct!=null)
			{
				if(ct.val==n.val)
				{
					pre_prev.next=ct.next;
				}
				else{
				pre_prev=ct;
				}
				ct=ct.next;
			}
			n=n.next;
		}
		return hd;
	}

	private static void display(ListNode hd) {
		ListNode n=hd;

		while(n!=null)
		{
			System.out.print(n.val + "->");
			n=n.next;
		}
	}
}
