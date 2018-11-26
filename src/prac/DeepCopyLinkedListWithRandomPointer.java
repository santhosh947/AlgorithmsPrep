package prac;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class DeepCopyLinkedListWithRandomPointer {

	public static RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode pointer = head;

		RandomListNode newHead = null;
		RandomListNode pre_newHd = newHead;
		while (pointer != null) {
			RandomListNode temp = new RandomListNode(pointer.label);
			hm.put(pointer, temp);
			if (newHead == null) {
				newHead = temp;
				pre_newHd = newHead;
			} else {

				pre_newHd.next = temp;
				pre_newHd = temp;

			}
			pointer = pointer.next;
		}

		pointer = head;
		RandomListNode new_pt = newHead;
		while (pointer != null && new_pt != null) {
			new_pt.random = hm.get(pointer.random);
			pointer = pointer.next;
			new_pt = new_pt.next;
		}
		return newHead;
	}

	//incomplete
	public static RandomListNode copyRandomList2(RandomListNode head) {
		RandomListNode pt = head;
		while(pt!=null)
		{
			RandomListNode tmp= new RandomListNode(pt.label);
			tmp.next=pt.next;
			pt.next=tmp;
			pt=pt.next.next;
		}
		pt=head;
		while(pt!=null)
		{
			if(pt.random!=null)
			{
				pt.next.random=pt.random.next;
			}
			pt=pt.next;
		}

		return head;
	}
}
