package Practice_Nov_2019;

import java.util.*;

class MergeSortedLists {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        ListNode t = a1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        System.out.println();

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        t = b1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        ListNode res = mergeTwoLists(a1,b1);

        System.out.println();
        t = res;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }
    }

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode res = null;
        ListNode t_l1 = l1;
        ListNode t_l2 = l2;
        ListNode t_res = res;


        while(t_l1 != null && t_l2 != null)
        {
            int next_val = 0;
            int v1 = t_l1.val;
            int v2 = t_l2.val;

            if(v1>= v2)
            {
                next_val = v2;
                t_l2 = t_l2.next;
            }
            else 
            {
                next_val = v1;
                t_l1 = t_l1.next;
            }

            if(res == null)
            {
                res = new ListNode(next_val);
                t_res = res;
            }
            else 
            {
                t_res.next = new ListNode(next_val);
                t_res = t_res.next;
            }
        }

        while(t_l1 !=null)
        {
            if(res == null)
            {
                res = new ListNode(t_l1.val);
                t_res = res;
            }
            else 
            {
                t_res.next = new ListNode(t_l1.val);
                t_res = t_res.next;
            }
            t_l1 = t_l1.next;
        }

        while(t_l2 !=null)
        {
            if(res == null)
            {
                res = new ListNode(t_l2.val);
                t_res = res;
            }
            else 
            {
                t_res.next = new ListNode(t_l2.val);
                t_res = t_res.next;
            }
            t_l2 = t_l2.next;
        }

        return res;
    }
}