package Practice_Nov_2019;

import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

public class CopyRandomLinkedList {
    public Node copyRandomList(Node l1) {
        Node res = null;

        if(l1 == null)
            return l1;

            Node t_l1 = l1;

        while(t_l1!=null)
        {
            Node cpy = new Node(t_l1.val, t_l1.next, null);
            t_l1.next = cpy;
            t_l1 = cpy.next;
        }

        t_l1 = l1;

        while(t_l1!= null)
        {
            t_l1.next.random = t_l1.random !=null ? t_l1.random.next : null;
            t_l1 = t_l1.next.next;
        }

        Node t_res = res;

        t_l1 = l1;
        while(t_l1!= null)
        {
            if(t_res==null)
            {
                t_res = t_l1.next;
                res = t_l1.next;
            }
            else
            {
                t_res.next = t_l1.next;
                t_res = t_res.next;
            }
            t_l1.next = t_l1.next.next;
            t_l1 = t_l1.next;
        }

        return res;
    }
}