package prac;

import java.util.LinkedList;
import java.util.Stack;

class linkedList11 {
	int data;
	linkedList11 next = null;

	public linkedList11(int d) {
		this.data = d;
	}

	void appendToTail(int d) {
		linkedList11 tail = new linkedList11(d);
		linkedList11 nd = this;
		while (nd.next != null)
			nd = nd.next;

		nd.next = tail;
	}
}

public class addLinkedList {

	LinkedList<Integer> r;
	static Stack<Integer> op;
	static int carry = 0;
	static linkedList11 output;

	public static void main(String[] args) {

		linkedList11 l1 = new linkedList11(1);
		linkedList11 l2 = new linkedList11(2);
		linkedList11 l3 = new linkedList11(3);
		linkedList11 m1 = new linkedList11(9);
		linkedList11 m2 = new linkedList11(8);
		linkedList11 m3 = new linkedList11(7);

		l1.next = l2;
		l2.next = l3;

		m1.next = m2;
		//m2.next = m3;

		add(l1, m1);

		try
		{
		output = new linkedList11(op.pop());
		linkedList11 temp = output;
		int len=op.size();
		// output.next=temp;
		for (int i = 0; i < len; i++) {
			temp.next = new linkedList11(op.pop());
			temp = temp.next;
		}
		temp=null;
		show();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void show() {
		linkedList11 curr = output;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}

	private static void add(linkedList11 l1, linkedList11 m1) {
		int l_size = findSize(l1);
		int m_size = findSize(m1);
		op = new Stack<>();
 
		if (l_size == m_size) {
			recurrsiveAdd(l1, m1);
			if(carry>0)
				op.add(carry);
		} else {
			if (l_size > m_size) {
				linkedList11 temp;
				temp = l1;
				int index = l_size - m_size;
				linkedList11 prev;

				for (int i = 0; i < index; i++) {
					prev=temp;
					temp = temp.next;
				}
				carry = 0;
				recurrsiveAdd(temp, m1);
				if(carry>0)
				{
					
				}
			} else {
				linkedList11 temp;
				temp = m1;
				int index = m_size - l_size;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				carry = 0;
				recurrsiveAdd(l1, temp);
			}
		}

	}

	private static int findSize(linkedList11 l1) {
		int r = 0;
		while (l1 != null) {
			l1 = l1.next;
			r++;
		}
		return r;
	}

	private static void recurrsiveAdd(linkedList11 l1, linkedList11 m1) {
		try {
			if (l1 == null || m1 == null) {
				return;
			}
			recurrsiveAdd(l1.next, m1.next);
			int sum = l1.data + m1.data + carry;
			carry = (sum >= 10) ? 1 : 0;
			int base = (sum > 10) ? sum % 10 : 0;
			op.add(base);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
