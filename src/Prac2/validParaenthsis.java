package Prac2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParaenthsis {
	
	public static void main(String[] args)
	{
		String in1 = "((";
		String in2 = "()[]{}";
		/*System.out.println(isValid(in1));
		System.out.println(isValid(in2));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));*/
		System.out.println(isValid2("{[]}"));
		//System.out.println(isValid("){");
		
	}
	
	public static boolean isValid(String s)
	{
		if(s== null || s.length()==1)
			return false;
		Map<Character,Character> lookUp = new HashMap<Character,Character>();
		
		lookUp.put('(',')');
		lookUp.put('{','}');

		lookUp.put('[',']');

		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			if(lookUp.containsKey(s.charAt(i)))
			{
				st.push(lookUp.get(s.charAt(i)));
			}
			else
			{
				if(st.empty())
					return false;
				if(st.pop()!=s.charAt(i))
					return false;
			}			
		}
		if(!st.empty())
			return false;
		
		return true;
	}
	
	 public static boolean isValid2(String str) {
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
