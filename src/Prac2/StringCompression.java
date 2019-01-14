package Prac2;

public class StringCompression {
	public static void main(String[] args) {
		char[] ch = {'a','a','b','b','c','c','c'};
		System.out.println(lenOfCompressed(ch));
	}
	
	public static int lenOfCompressed(char[] ch)
	{
		if(ch==null)
			return -1;
		
		if(ch.length==1)
			return 1;
		
				
		int ct = 1;
		for(int i=1;i<ch.length;i++)
		{
			if(ch[i] == ch[i-1])
			{
				ct++;
			}
			else
			{
				
			}			
		}
		return -1;
	}
}
