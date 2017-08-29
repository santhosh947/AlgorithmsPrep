
/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://leetcode.com/problems/maximum-subarray/discuss/
 * 
 * @author santh
 *
 */
public class MaximumContinousSubArray {
	public static void main(String[] args) {
	    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	    System.out.println(maximumSubArray(a));
	}
	
	public static int maximumSubArray(int[] arr)
	{
		int max_so_far=Integer.MIN_VALUE;
		int max_here=0;
		for(int i=0;i<arr.length;i++)
		{
			max_here+=arr[i];
			if(max_so_far<max_here)
			{
				max_so_far=max_here;
			}
			if(max_here<0)
			{
				max_here=0;
			}
		}
		return max_so_far;
	}
}
