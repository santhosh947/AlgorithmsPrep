package Practice_Nov_2019.Array;

class L53MaximumSubarray {
    public static void main(String[] args) {
        int[] n = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(n));
    }

    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int local_max = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            local_max= Math.max(nums[i]+local_max, nums[i]);
            max = Math.max(max, local_max);
        }
        return max;

    }
}