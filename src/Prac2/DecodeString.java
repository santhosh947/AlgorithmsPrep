package Prac2;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	
	public static String decodeString(String v)
	{
		String res ="";
		Stack st = new Stack<String>();
		for(int i=0;i<v.length();i++)
		{
			char c = v.charAt(i);
			if(c==']')
			{
				processStack(st);
			}
			else
			{
				st.push(c);
			}
			
		}
		return (String) st.pop();
	}
	
	public static void processStack(Stack st)
	{
		String res = "";
		String tempSt = "";
		boolean isBreak = false;
		while(!st.isEmpty() && !isBreak){
			String c= (String) st.pop();
			int d = isDigit(c);
			if(d!=-1)
				isBreak=true;
			
			//if(c!='[')
			{
				tempSt = tempSt + c;
			}
			
			if(isBreak)
			{
				for (int i = 0; i < d; i++) {
					res+=tempSt;
				}
			}			
		}
		if(res!="")
			st.push(res);
	}
	
	public static int isDigit(String c)
	{
		int it = -1;
		
		
		return it;
	}
}
