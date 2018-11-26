package prac;

import java.util.Stack;

public class StackDemoInJava {

	public static void main(String[] args) {

		Stack st = new Stack<Integer>();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push('a');
		System.out.println(st.size());
		System.out.println("Peek Check :" + st.peek());
		System.out.println("Pop " + st.pop());
		System.out.println("Peek Check :" + st.peek());
		System.out.println("Pop " + st.pop());
		System.out.println("Peek Check :" + st.peek());
		System.out.println("Pop " + st.pop());
		System.out.println("Peek Check :" + st.peek());
		System.out.println("Pop " + st.pop());

	}

}
