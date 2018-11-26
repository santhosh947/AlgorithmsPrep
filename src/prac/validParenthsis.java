package prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParenthsis {
	public static void main(String[] args) {
		System.out.println(isValidParanthesis("["));
	}

	public static boolean isValidParanthesis(String str) {
		Map<Character, Character> validBrackets = new HashMap<Character, Character>();
		validBrackets.put(')', '(');
		validBrackets.put('}', '{');
		validBrackets.put(']', '[');

		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (validBrackets.containsKey(str.charAt(i))) {
				if (st.isEmpty()) {
					return false;
				} else {
					if (st.pop() != validBrackets.get(str.charAt(i)))
						return false;
				}
			} else {
				st.push(str.charAt(i));
			}
		}
		if(!st.isEmpty())
			return false;
		return true;

	}
}
