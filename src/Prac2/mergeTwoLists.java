package Prac2;

// Definition for singly-linked list.

public class mergeTwoLists {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode res = null;
		ListNode cur_res = res;
		while (t1 != null && t2 != null) {
			if(t1.val < t2.val)
			{
				if(res == null)
				{
					res.val = t1.val;
					cur_res = res;
				}
			}
		}
		return res;
	}
}
