package Prc_2020_Q4;

import java.util.*;

class L62UniquePaths {

    private static class ListNode {
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

    public static void main(String[] args) {

        ListNode l = new ListNode(1);

        ListNode res = removeNthFromEnd(l, 1);
        System.out.println("hi");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode res = slow;
        ListNode fast = head;

        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next != null ? slow.next.next : null;

        return res.next;
    }
}