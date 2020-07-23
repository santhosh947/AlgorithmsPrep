package Old_files;

public class test {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		
		int[] res=productExceptSelf(nums);
		for(int i:res)
			System.out.println(i);
	}
	    public static int[] productExceptSelf(int[] nums) {
	        int[] res = new int[nums.length];
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

}
