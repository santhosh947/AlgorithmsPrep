package Old_files;



public class MergeSortedLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	//Non recursive approach
	public ListNode mergeTwoListsNonRecursive(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode t=head;
        if(l1==null && l2==null)
            return null;
        if(l1==null && l2!=null)
            return l2;
        if(l1!=null && l2==null)
            return l1;
        
        
        while(l1!=null && l2!=null)
        {
            if(l1.val>l2.val)
            {
               ListNode temp=new ListNode(l2.val);
               if(t==null)
               {
                   head=temp;
                   t=head;
               }
                else
                {
                    t.next=temp;
                    t=t.next;

                }
                l2=l2.next;
            }
            else
            {
               ListNode temp=new ListNode(l1.val);
               if(t==null)
               {
                   head=temp;
                   t=head;
               }
                else
                {
                    t.next=temp;
                    t=t.next;

                }
                l1=l1.next;
            }
        }
        
        if(l1!=null)
            t.next=l1;
        if(l2!=null)
            t.next=l2;
        
        return head;
    }
	//recursive approach
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode hd;
	        if(l1==null && l2==null)
	            return null;
	        
	        if(l1==null && l2!=null)
	            return l2;
	        
	        if(l2==null && l1!=null)
	            return l1;
	        
     if(l1.val<l2.val)
     {
         hd=l1;
         hd.next=mergeTwoLists(l1.next,l2);
     }
     else
     {
         hd=l2;
         hd.next=mergeTwoLists(l1,l2.next);
     }
     return hd;
 }
}


