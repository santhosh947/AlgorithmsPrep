package Practice_Nov_2019;

public class MoveZerosToEnd
{
    public static void main(String[] args) {
        /**
         * Input: [0,1,0,3,12]
         * Output: [1,3,12,0,0]
         */

         int[] a = {0,1,0,3,12};
         for(int i : a)
         {
             System.out.print(i + ",");
         }

         System.out.println("  ");
         moveZeroes(a);
         for(int i : a)
         {
             System.out.print(i + ",");
         }
    }
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <2)
            return;

        int setSize = nums[0] == 0 ? 1 : 0;

        for(int i=0,j=1;i<nums.length-1 && j<nums.length;i++,j++)
        {
            if(nums[j]==0)
            {
                setSize++;
            }
            if(nums[i]==0 && nums[i]!=nums[j])
            {
                nums[j-setSize] = nums[j];
                nums[j]=0;
            }
        }
    }
}