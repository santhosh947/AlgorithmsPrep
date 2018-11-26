package prac;

public class LeetAddLinkedList2 {
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l1_2=new ListNode(4);
		ListNode l1_3=new ListNode(3);
		//l1.next=l1_2;
		l1_2.next=l1_3;
		
		ListNode l2=new ListNode(9);
		ListNode l2_2=new ListNode(9);
		ListNode l2_3=new ListNode(4);
		l2.next=l2_2;
		//l2_2.next=l2_3;
		
		ListNode res=addTwoNumbers(l1, l2);
		while(res!=null)
		{
			System.out.println(res.val);
			res=res.next;
		}
		
		
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=findLength(l1);
        int len2=findLength(l2);
        ListNode res=null;
        if(len1==len2)
        {
           res= Addition(l1,l2);
        }
        if(len1>len2)
        {
            res=Addition(l1,patchUp(l2,len1-len2));
        }
        if(len2>len1)
        {
            res=Addition(l2,patchUp(l1,len2-len1));
        }
        return res;
        
    }
        public static ListNode Addition(ListNode n1,ListNode n2)
        {
            ListNode res=null;
            ListNode head=null;
            ListNode hd_pt=head;
            int carry=0;
            while(n1!=null && n2!=null)
            {
                int add=n1.val+n2.val+carry;
                if(add>9)
                {
                    carry=add/10;
                    add=add%10;
                }
                else
                {
                	carry=0;
                }
                res=new ListNode(add);
                if(head==null)
                {
                    head=res;
                    hd_pt=head;
                }
                else
                {
                    hd_pt.next=res;
                    hd_pt=hd_pt.next;
                }
                n1=n1.next;
                n2=n2.next;
            }
            if (carry==1)
            	hd_pt.next=new ListNode(carry);
            return head;
            
        }
    public static ListNode patchUp(ListNode l,int len)
    {
        ListNode res=null;
        ListNode temp=l;
        ListNode prev=l;
        while(l!=null)
        {
        	prev=l;
            l=l.next;
        }
        for(int i=0;i<len;i++)
        {
            res=new ListNode(0);
            prev.next=res;
            prev=prev.next;
        }
        return temp;
    }
    public static int findLength(ListNode l1)
    {
        int c=0;
        while(l1!=null)
        {
            c++;
            l1=l1.next;
        }
        return c;
    }
}
