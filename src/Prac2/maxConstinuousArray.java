package Prac2;

public class maxConstinuousArray {
	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		int[] b = {-10,-1};
        System.out.println("Maximum contiguous sum is " + 
                maxSubArraySum(b));
	}

	private static int maxSubArraySum(int[] a) {
		
		if(a==null || a.length==0)
			return 0;
		int localMax = a[0];
		int max = a[0];

		for(int i=1;i<a.length;i++)
		{
			localMax =  Math.max(localMax+a[i], a[i]);
			max = Math.max(max, localMax);			
		}
		return max;
	}
}
