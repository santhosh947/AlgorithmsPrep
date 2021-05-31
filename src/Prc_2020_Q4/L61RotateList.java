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

public class L61RotateList {
    static ListNode tail = null;

    public static void main(String[] args) {
        ListNode nd1 = new ListNode(1);
        ListNode nd2 = new ListNode(2);
        ListNode nd3 = new ListNode(3);

        nd1.next = nd2;
        nd2.next = nd3;

        show(nd1);
        ListNode rev = rotateRight(nd1, 5);

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

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(-1, head);

        int n = findLen(head);
        // int rem = n % k;
        k = k > n ? k % n : k;

        if (k == 0)
            return head;

        ListNode prev_node = findNodeToRev(newHead, n - k);

        System.out.println(prev_node.val);
        ListNode oldHead = newHead.next;
        tail.next = oldHead;
        newHead.next = prev_node.next;
        prev_node.next = null;

        return newHead.next;

    }

    public static ListNode findNodeToRev(ListNode h, int pos) {
        if (h == null)
            return null;

        System.out.println("Step 2:- " + h.val);
        System.out.println("Step 3:- " + pos);

        // ListNode nd = h;
        while (pos > 0 && h != null) {
            h = h.next;
            pos--;
        }

        return h;
    }

    public static int findLen(ListNode h) {
        if (h == null)
            return 0;
        int n = 0;
        while (h != null) {
            n++;
            if (h.next == null) {
                tail = h;
            }
            h = h.next;
        }

        return n;
    }
}
