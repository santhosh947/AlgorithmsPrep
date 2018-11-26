package Prac2;

public class fib {
	public static void main(String[] args) {
		findNthFib(5);
	}

	private static void findNthFib(int n) {
		int[] cache = new int[n+1];
		for(int i=0;i< n; i++)
		{
			System.out.println(findFib(i,cache));
		}
		//return cache[n];
	}

	private static int findFib(int i, int[] cache) {
		
		if(i<=0)
			return 0;
		else if(i==1)
			return 1;
		else if(cache[i]>0)
			return cache[i];
		
		cache[i] = findFib(i-1, cache) + findFib(i-2, cache);
		
		return cache[i];
		
	}
}
