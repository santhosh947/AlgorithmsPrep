package Practice_Nov_2019;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}
/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class AddTwoLinkedListNumbers
{
    public static void main(String[] args)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
      //  b2.next = b3;

        ListNode t = a1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        System.out.println();
        t = b1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        ListNode res = addTwoNumbers(a1,b1);

        System.out.println();
        t = res;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode t_l1 = l1;
        ListNode t_l2 = l2;

        int carry = 0;
        ListNode t_res = res;
        while(t_l1!=null || t_l2!=null || carry > 0)
        {
            int t = (t_l1 != null ? t_l1.val : 0) + (t_l2 !=null ? t_l2.val : 0) + carry;
            if (t >= 10) 
                carry = t/10;
            else 
                carry=0;
            int rem = t%10;
            if(res == null)
            {
                res = new ListNode(rem);
                t_res = res;
            }
            else
            {
                t_res.next = new ListNode(rem);
                t_res = t_res.next;
            }
            t_l1 = t_l1 == null ? null : t_l1.next;
            t_l2 = t_l2 == null ? null : t_l2.next;
        }        
        return res;
    }
}