package Dec_2019_Prep;

public class NondecreasingArray {
	public static void main(String[] args) {
		int[] n = {2,3,3,2,4};
		System.out.println(checkPossibility(n));
	}
	public static boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length < 3)
            return true;
        
        
        int curr = 0;
        int fwd = 1;
        int ctr = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[curr] > nums[fwd])
            {
                ctr++;
                nums[curr] = nums[fwd]-1;

                if(ctr>1 || (curr>0 ? nums[curr-1] > nums[curr] : false))
                	return false;
            }
            curr++;
            fwd++;
        }
        if(ctr > 1)
            return false;
        
        return true;
    }
}
