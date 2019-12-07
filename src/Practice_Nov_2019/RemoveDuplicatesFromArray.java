package Practice_Nov_2019;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] a = {1,1,2};

        for(int i : a)
        {
            System.out.print(i +",");
        }

        System.out.println();

        int ddedup = removeDuplicates(a);

        System.out.println("Dedup : " + ddedup);
        for(int i : a)
        {
            System.out.print(i +",");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int res = 1;
 
         int curr =1;
         int size = 0;
         for(int i=0;i<nums.length -1 && curr < nums.length;i++,curr++)
         {
             if(nums[i] == nums[curr])
             {
                 size++;
             }
             else 
             {
                res++;
                nums[curr-size] = nums[curr];
             }
         }
         return res;
    }

    public static int removeDuplicates2(int[] nums) {
        int res = 1;
       // int st = 0;
        int end = nums.length -1;

        int next =1;
        for(int i=0;i<nums.length -1 && next < nums.length;i++)
        {
            next = i+1;
            if(nums[i]<nums[next])
            {
                res++;
            }
            else 
            {
                if(next+1<nums.length)
                {
                    int t= nums[next];
                    nums[next] = nums[next+1];
                    nums[next+1] = t;
                }
            }
        }
        return res;
    }
}