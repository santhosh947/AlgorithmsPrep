package prac;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * 
 * Solution https://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div/2696005#2696005
 * 
 * @author SC043656
 *
 */
public class ProductExceptItSelf {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int[] res= productExceptSelf_2(arr);
		for(int i:res)
		{
			System.out.print(i +" ");
		}
		System.out.println();
		int[] res2= prd(arr);
		for(int i:res2)
		{
			System.out.print(i +" ");
		}
	}
	public static int[] productExceptSelf(int[] nums) {
	    int n = nums.length;
	    int[] res = new int[n];
	    res[0] = 1;
	    for (int i = 1; i < n; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    return res;
	}
	
	public static int[] productExceptSelf_2(int[] nums) {
        int[] res=new int[nums.length];
        int m=1;
        for(int i=0;i<nums.length;i++)
        {
            res[i]=m;
            m*=nums[i];
        }
        
        m=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            res[i]*=m;
            m*=nums[i];
        }
        return res;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] prd(int[] n)
	{
		int[] res=new int[n.length];
		int m=1;
		for(int i=0;i<n.length;i++)
		{
			res[i]=m;
			m*=n[i];
		}
		m=1;
		for(int i=n.length-1;i>=0;i--)
		{
			res[i]*=m;
			m*=n[i];
		}
		return res;
	}
}
