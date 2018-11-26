package prac;

import java.util.HashMap;
import java.util.Map;

public class rotateMat {
	public static void main(String[] args) {
		//System.out.println(firstUniqChar("loveleetcode"));
		//[-10,-10,-9,-4,1,6,6]
		//[-7]
		ListNode l1=new ListNode(1);
		ListNode l2= new ListNode(2);
		
		int[] arr1 = {-10,-10,-9,-4,1,6,6};
		ListNode i1=createLinkedList(arr1);
		int[] arr2 = {-7};
		ListNode i2=createLinkedList(arr2 );
		/*display(i1);
		display(i2);
		ListNode res=mergeTwoLists_old(i1, i2);
		display(res);*/
		
		
		

	}
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		TreeNode hd;
		if(t1==null && t2==null )
		{
			return null;
		}
		if(t1==null)
		{
			hd=t2;
			return hd;
		}
		if(t2==null)
		{
			hd=t1;
			return hd;
		}

		hd = new TreeNode(t1.val+t2.val);
		hd.left=mergeTrees(t1.left,t2.left);
		hd.right=mergeTrees(t1.right,t2.right);
		return hd;
	}
	private static ListNode createLinkedList(int[] arr) {
		ListNode hd=null;
		ListNode pt=hd;
		for(int i=0;i<arr.length;i++)
		{
			if(hd==null)
			{
				hd = new ListNode(arr[i]);
				pt=hd;
			}
			else
			{
				ListNode tmp = new ListNode(arr[i]);
				pt.next=tmp;
				pt=pt.next;
			}
		}
		return hd;
	}
	
	public static void display(ListNode l)
	{
		System.out.println();
		while(l!=null)
		{
			System.out.print(l.val + "->");
			l=l.next;
		}
	}
	
	 public static ListNode mergeTwoLists_old(ListNode l1, ListNode l2) {
	        ListNode hd=null;
	        if(l1==null && l2==null)
	            return hd;
	        
	        if(l1==null && l2!=null)
	            return l2;
	        
	        if(l2==null && l1!=null)
	            return l1;
	        
	        ListNode pointer=hd;
	        while(l1!=null && l2!=null)
	        {
	            if(l1.val>l2.val)
	            {
	                ListNode temp= new ListNode(l2.val);
	                if(hd==null)
	                {
	                    hd=temp;
	                    pointer=hd;
	                }
	                else
	                {
	                    pointer.next=temp;
	                    pointer=pointer.next;
	                }
	                l2=l2.next;
	            }
	            else
	            {
	                ListNode temp= new ListNode(l1.val);
	                if(hd==null)
	                {
	                    hd=temp;
	                    pointer=hd;
	                }
	                else
	                {
	                    pointer.next=temp;
	                    pointer=pointer.next;
	                }
	                l1=l1.next;
	            }
	        }
	        while(l1!=null)
	        {
	            pointer.next=l1;
	            l1=l1.next;
	            pointer=pointer.next;
	        }
	        while(l2!=null)
	        {
	            pointer.next=l2;
	            l2=l2.next;
	            pointer=pointer.next;

	        }
	        return hd;
	    }

	public static ListNode mergeTwoLists(ListNode ln1, ListNode ln2) {
		ListNode hd=null;
		ListNode l1 = ln1;
		ListNode l2= ln2;
		if (l1 == null && l2 == null)
			return hd;

		if (l1 == null && l2 != null)
			return l2;

		if (l2 == null && l1 != null)
			return l1;
		
		if(l1.val>l2.val)
		{
			ListNode l2_prev=l2;
			while(l2!=null)
			{
					l2_prev=l2;
					l2=l2.next;
				
			}
			l2_prev.next=l1;
			return ln2;
		}
		else
		{
			ListNode l1_prev=l1;
			while(l1!=null)
			{
				l1_prev=l1;
				l1=l1.next;
			}
			l1_prev.next=l2;
			return ln1;
		}	
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != null && fast != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				fast = null;
		}
		return false;
	}

	public static int firstUniqChar(String s) {
		int res = -1;

		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hm.containsKey(ch)) {
				int t = hm.get(ch);
				hm.put(ch, ++t);
			} else {
				hm.put(ch, 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hm.get(ch) == 1)
				return i;
		}
		return res;
	}

	public static void rotate(int[][] mat) {
		int n = mat.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int off = i - first;

				// move top to temp
				int t = mat[first][i];

				// move left to top
				mat[first][i] = mat[last - off][first];

				// move bottom to left
				mat[last - off][first] = mat[last][last - off];

				// move right to bottom=
				mat[last][last - off] = mat[i][last];

				mat[i][last] = t;

			}

		}

	}
}
