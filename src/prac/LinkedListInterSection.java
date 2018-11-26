package prac;

public class LinkedListInterSection {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;

        int la = findLen(headA);
        int lb = findLen(headB);
        if(la>lb)
        {
            headB=addExtraNodes(la-lb,headB);
        }
        else if(la<lb)
        {
            headA=addExtraNodes(lb-la,headA);
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
                return headB;
            headA=headA.next;
            headB=headB.next;
        }
        return null;        
    }
    
    public static ListNode addExtraNodes(int len, ListNode hd)
    {
        ListNode temp=hd;
        while(len>0)
        {
            ListNode t = new ListNode(-1);
            t.next=temp;
            temp=t;
            len--;
        }
        return temp;
    }
    
    public static int findLen(ListNode hd)
    {
        int len=0;
        if(hd==null)
            return len;
        while(hd!=null)
        {
            len++;
            hd=hd.next;
        }
        return len;
    }
}
