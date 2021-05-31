package Prc_2020_Q4;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class L206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode nd1 = new ListNode(1);
        ListNode nd2 = new ListNode(2);
        ListNode nd3 = new ListNode(3);

        nd1.next = nd2;
        nd2.next = nd3;

        show(nd1);
        ListNode rev = reverseList(nd1);

        System.out.println();
        show(rev);
        System.out.println();
    }

    public static void show(ListNode nd) {
        ListNode curr = nd;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    public static ListNode rev = null;
    public static ListNode rev_ptr = rev;

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        reverse(head);

        return rev;
    }

    public static ListNode reverse(ListNode r) {
        if (r == null)
            return r;

        ListNode tmp_nd = reverse(r.next);

        if (tmp_nd == null) {
            rev = r;
            rev_ptr = rev;
            rev_ptr.next = null;
        } else {
            rev_ptr.next = r;
            rev_ptr = rev_ptr.next;
            rev_ptr.next = null;
        }

        return r;

    }

}
