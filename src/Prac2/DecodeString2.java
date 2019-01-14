package Prac2;

import java.util.Stack;

public class DecodeString2 {
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String v) {
		String res = "";
		Stack st = new Stack<String>();
		for (int i = 0; i < v.length(); i++) {
			char c = v.charAt(i);
			if (c == ']') {
				processStack(st);
			} else {
				st.push(String.valueOf(c));
			}
		}
		while(!st.isEmpty())
		{
			res = st.pop()+res;
			
		}
		return res;
	}

	public static void processStack(Stack<String> st) {
		int it = 0;
		String substr = "";
		boolean numBuilder = false;
		boolean isProcessed=false;
		int base=1;
		while (!st.isEmpty() && !isProcessed) {
			String str = (String) st.pop();
			
			if(numBuilder)
			{
				int val = isDigit(str.charAt(0));
				if(val==-1)
				{
					numBuilder=false;
					st.push(str);
					if (substr != "" && it > 0) {
						st.push(stringGenerator(substr, it));
						isProcessed=true;
						substr="";
						it=0;
					}
				}
				else
				{
					it = it + base * val;
					
					base=base *10;
				}
			}
			else if(str.length()==1 && str.charAt(0)=='[')
			{
				numBuilder=true;
			}
			else
			{
				substr=str+substr;
			}
		}
		if (substr != "" && it > 0) {
			st.push(stringGenerator(substr, it));
			substr="";
			it=0;
		}
	}
	
	public static int isDigit(char c)
	{
		int it = -1;
		
		if(c == '0' || c == '1' || c=='2' || c == '3' || c == '4' || c=='5' || c == '6' || c == '7' || c=='8' || c=='9')
		{
			it = Character.getNumericValue(c);		
		}
		return it;
	}
	
	public static String stringGenerator(String substr, int it) {
		String res = "";
		for (int i = 0; i < it; i++) {
			res += substr;
		}
		return res;
	}
}
