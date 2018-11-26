package prac;

public class LeetcodeDt715_findMaxAverage {
	public static void main(String[] args) {
		int[] a= {-1};
		
	System.out.println(findMaxAverage(a, 1));	
	}
	    public static double findMaxAverage(int[] nums, int k) {
	        double res=0.0;
	        int sum=Integer.MIN_VALUE;
	        int temp=0;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(i>k-1)
	            {
	                //if(i-k>=0)
	                if(sum<=temp)
	                {
	                    sum=temp;
	                }
	                temp=temp+nums[i]-nums[i-k];
	                
	                
	            }
	            else
	            {
	                temp+=nums[i];
	            }
	            
	        }
	        if(sum<=temp)
	                {
	                    sum=temp;
	                }
	        res=sum/(double)k;
	        return res;
	        
	    }
	}
