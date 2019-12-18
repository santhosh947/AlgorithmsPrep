package Practice_Nov_2019;

import java.util.*;

/**
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * 1,2,3,4
 * 4,3,2,1
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);


        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
      //  a3.next = a4;

        ListNode t = a0;
        while (t != null) {
            System.out.print(t.val + "->");
            t = t.next;
        }

        System.out.println();

        reorderList(a0);

        t = a0;
        while (t != null) {
            System.out.print(t.val + "->");
            t = t.next;
        }

        System.out.println();
    }

    public static void reorderList(ListNode head) {
        ListNode t_h = head;
        if (head == null || head.next==null)
            return;
        Stack<ListNode> st = new Stack();
        int ct = 0;
        while (t_h != null) {
            st.add(t_h);
            t_h = t_h.next;
            ct++;
        }

        int start = 1;
        t_h = head;
        while (start < ct) {
            ListNode temp = t_h.next;
            t_h.next = st.pop();
            t_h = t_h.next;
            t_h.next = temp;
            t_h = t_h.next;
            start += 2;
        }
        if (t_h.next != null) {
            if(ct%2==0)
                t_h.next.next = null;
            else   
                t_h.next.next.next = null;
        }
     }
}