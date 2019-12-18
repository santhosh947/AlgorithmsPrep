package Practice_Nov_2019;

import java.util.*;

/**
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
class ReorderLinkedList
{
    public static void main(String[] args) {
        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;

        ListNode t = a1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        System.out.println();

        reorderList(a1);

        t = a1;
        while(t!=null)
        {
            System.out.print(t.val +"->");
            t=t.next;
        }

        System.out.println();
    }

    public static void reorderList(ListNode head) {
        ListNode t_h = head;
        if(head == null)
            return;
        Map<Integer, ListNode> st = new HashMap<Integer, ListNode>();
        int ct = 0;
        while(t_h!=null)
        {
            st.put(ct, t_h);
            t_h = t_h.next;
            ct++;
        }

        int start = 0;
        ListNode  curr = head;
        ListNode prev =curr;
        while(start<ct)
        {
            ListNode temp = curr.next;
            t_h.next = st.get(--ct);
            start++;
            t_h= t_h.next;
            t_h.next=temp;
            t_h = t_h.next;
        }

    }
}