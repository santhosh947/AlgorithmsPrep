package Practice_Nov_2019.ResorviorSampling;

import java.util.*;

class L382LinkedListRandomNode {
    public static void main(String[] args) {

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class LinkedListRandomNode {
        Random rnd;
        int ct;
        ListNode root;

        public LinkedListRandomNode(ListNode head) {
            rnd = new Random();
            ListNode t = head;
            root=head;
            ct=0;
            while(t!=null){
                ct++;
                t=t.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int ele = rnd.nextInt(ct);
            ListNode t = root;
            while(ele==0 && t!=null){
                t=t.next;
            }
            return t.val;

        }
    }

   
}