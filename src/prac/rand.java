package prac;

public class rand {

	public static void main(String[] args0)
	{
		int[] str = new int[]{1,2,3,4};
		
		for(int i=0;i<4;i++)
		{
			System.out.println("random num is " + randam(str[i]));			
		}
	}
	static int res =0;
	static int count =0;
	
	public static int randam(int n)
	{
		
		count++;
		
		if(count==1)
			return n;
		else
		{
			int i = (int) ((Math.random()*101) % count);
			
			if(i==count-1)
				res=n;
		}
		return res;
	}
}
