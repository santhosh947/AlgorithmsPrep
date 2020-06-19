package Practice_Nov_2019;

public class test10 {
    public static void main(String[] args) {
        System.out.println("hi");

        //int[] n = {0,1,0,3,12};
        int[] n = {1,3,12,0,0};

        for(int a:n)
        {
            System.out.print(a+",");
        }
        moveZeroes(n);
        System.out.println();
        for(int a:n)
        {
            System.out.print(a+",");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i=-1,j=-1;
        if(nums==null || nums.length<2)
            return;
        
        for(int k=0;k<nums.length && i<nums.length && j<nums.length-1; k++)
        {
            if(nums[k]==0 && i==-1)
            {
                i=k;
                j=k;
            }
            if(nums[k]==0)
            {
                while(j<nums.length-1)
                {
                    if(j<nums.length-1 && nums[j+1]==0)
                    {
                        j++;
                    }
                    else if(nums[j+1]!=0)
                    {
                        nums[i]=nums[j+1];
                        nums[j+1]=0;
                        i=i+1;
                        j=j+1;
                    }
                }
            }
        }
    }
}