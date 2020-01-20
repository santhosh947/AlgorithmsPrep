package Prac2;

public class maxConstinuousArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, -7, 7, 2, -12, 6}; 
		int[] b = {-10,-1};
      //  System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
				
		int[] c = {2,1,1,2};
		System.out.println(rob(c));
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

	public static int rob(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        if(nums.length==1)
            return nums[0];
        
        
        int prevMax = 0;
        int currMax = 0;
        
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp = currMax;
            currMax= Math.max(currMax, prevMax+nums[i]);
            prevMax = temp;
        }
        
        return currMax;    
    }
}
