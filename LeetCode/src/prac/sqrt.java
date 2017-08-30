package prac;

public class sqrt {

	public static void main(String[] args) {

		int prev_sum=1,curr=1,sum=0,index=0;
		int N=101;
		int sqr = N*N;
		boolean isPerfectSqr=false;
		
		for(int i=1;i<sqr;i=i+2)
		{
			index++;
			if(sum==N)
			{
				isPerfectSqr=true;
				break;
			}
			else if(sum<N && prev_sum<N)
			{
				prev_sum=sum;
				sum=sum+i;
			}
			else if(sum>N && prev_sum<N)
			{
				index--;
				break;
			}
			
		}
		if(isPerfectSqr)
		{
			System.out.println(index);
			System.out.println(-index);
		}
		else
		{
			System.out.println(index);
			System.out.println(-(index-1));
		}
		System.out.println("***********");
		
		System.out.println(floorSqrt(4));
		
	}
	
	public static int floorSqrt(int x)
	{
		// Base cases
		if (x == 0 || x == 1)
		return x;

		// Staring from 1, try all numbers until
		// i*i is greater than or equal to x.
		int i = 1, result = 1;
		while (result < x)
		{
		if (result == x)
			return result;
		i++;
		result = i*i;
		}
		return i-1;
	}

}
