package prac;

class linkedList {
	int data;
	linkedList next = null;

	public linkedList(int d) {
		this.data = d;
	}

	void appendToTail(int d) {
		linkedList tail = new linkedList(d);
		linkedList nd = this;
		while (nd.next != null)
			nd = nd.next;

		nd.next = tail;
	}
}

public class linkedListPractice {
	static linkedList head;
	static int elementCount;

	public static void add(int data) {
		linkedList tail = new linkedList(data);

		if (head == null) {
			head = tail;
			return;
		}

		linkedList curr = head;
		linkedList prev = head;

		while (curr != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = tail;
		elementCount++;
	}

	public static void show() {
		linkedList curr = head;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}

	public static linkedList deleteDuplicates(linkedList head1) {

		if (head1.next == null) {
			return head1;
		}

		linkedList curr = head1;
		linkedList forward = head1.next;

		while (forward != null) {
			if (curr != null && forward.data == curr.data) {
				// curr.next = forward.next;
				forward = forward.next;
			}
			curr.next = forward;
			curr = forward;
			// head.next=forward;
		}
		return head1;
	}

	public static void deleteDuplicates1() {

		if (head.next == null || head == null) {
			return;
		}

		linkedList curr = head;
		linkedList forward = head.next;

		while (forward != null) {
			if (forward.data == curr.data) {
				curr.next = forward.next;
				forward = forward.next;
			} else {
				curr = forward;
				forward = forward.next;
			}
		}
		// return head;
	}

	public static void deleteDuplicatesRecursive() {
		linkedList curr = head;
		linkedList forward = head.next;
		recurrDelete(curr, forward);

	}

	static linkedList newHead = null;

	public static void reverseList() {
		linkedList prev = head;
		linkedList curr = head.next;
		recurrsiveReversal(prev, curr);
		prev.next = null;
		head = newHead;
	}

	public static void recurrsiveReversal(linkedList prev, linkedList curr) {
		if (curr == null)
			return;

		linkedList pr = curr;
		linkedList cr = curr.next;
		// recurrsiveReversal(pr, cr);
		recurrsiveReversal(curr, curr.next);

		if (newHead == null)
			newHead = curr;
		// newHead.next = prev;

		curr.next = prev;
	}

	public static void show2() {
		linkedList curr = newHead;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}

	private static void recurrDelete(linkedList curr, linkedList forward) {
		if (forward == null)
			return;
		if (curr.data == forward.data) {
			curr.next = forward.next;
			forward = forward.next;
		} else {
			curr = forward;
			forward = forward.next;
		}
		recurrDelete(curr, forward);
	}

	public static void main(String[] args) {
		add(10);
		// add(10);

		add(20);
		// add(20);

		add(5);
		add(2);
		/*
		 * add(20); add(10);
		 */
		show();
		// removeDuplicates();
		// head=deleteDuplicates(head);
		// deleteDuplicates1();
		// deleteDuplicatesRecursive();
		// reverseList();
		// removeDup();

		head=partition(6);

		System.out.println();
		show();
		System.out.println();

		// System.out.println("Min " +findMin());
		// show();

		// remove(5);
		// show();

	}

	private static linkedList partition(int i) {

		linkedList hd = head;
		linkedList tail = head;
		linkedList temp = head;
		while (temp != null) {
			linkedList next = temp.next;
			if (temp.data < i) {
				temp.next = hd;
				hd = temp;
			} else {
				tail.next = temp;
				tail=temp;
			}
			temp=next;
		}
		tail.next=null;
		return hd;
	}

	private static void remove(int i) {

		linkedList temp = head.next;
		linkedList prev = head;
		linkedList prev_prev = null;

		while (temp != null) {
			if (prev.data == i) {
				prev.data = temp.data;
				prev.next = temp.next;
			} else {
				prev_prev = prev;
				prev = temp;
			}
			temp = temp.next;
		}
		if (prev.data == i) {
			prev_prev.next = null;
			prev = null;
		}
	}

	public static void removeDuplicates() {
		linkedList prev = head;
		linkedList curr = head.next;
		linkedList curr_before = head;

		while (curr != null) {
			prev = head;
			boolean match = false;
			while (prev != curr) {
				if (prev.data == curr.data) {
					curr_before.next = curr.next;
					match = true;
					curr = curr.next;
					break;
				}
				prev = prev.next;
			}
			if (curr != null && !match) {
				curr_before = curr;
				curr = curr.next;
			}
		}
	}

	public static void removeDup() {
		linkedList prev = head;
		linkedList curr = head.next;
		linkedList curr_before = head;

		while (curr != null) {
			boolean isMatch = false;
			prev = head;
			while (prev != curr) {
				if (prev.data == curr.data) {
					curr_before.next = curr.next;
					isMatch = true;
					break;
				}
				prev = prev.next;
			}
			if (curr != null && !isMatch) {
				curr_before = curr;
			}
			curr = curr.next;

		}
	}

	public static int findMin() {
		if (head == null)
			return 0;
		int min = head.data;
		linkedList curr = head;
		while (curr != null) {
			if (curr.data < min) {
				min = curr.data;
			}
			curr = curr.next;
		}
		return min;
	}
	
	
	

}