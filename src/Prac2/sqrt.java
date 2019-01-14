package Prac2;

public class sqrt {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
	
	public static int mySqrt(int n)
	{
		float c = 0;
		int s = 0;
		int e = n;
		if(n == 1)
			return n;
		
		if(n<1)
			return 0;
		
		while(true)
		{
			if((c*c <= n) && ((c+1)*(c+1)>n))
				break;
			else if(c*c < n)
			{
				float x = c;
				c = (s+e)/2;
				s = (int)x;
			}
			else if(c*c > n)
			{
				float x = c;
				c = (s+e)/2;
				e = (int)x;
			}
		}
		return (int)c;
	}
}
