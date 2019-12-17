package Practice_Nov_2019;

import java.util.*;
public class NextPermutation {
    public static void main(String[] args) {
        // int[] nums = {1,3,2};
        // for (int i : nums) {
        //     System.out.print(i+",");
        // }
        // System.out.println();

        // nextPermutation(nums);

        // for (int i : nums) {
        //     System.out.print(i+",");
        // }
        // System.out.println();


        int[] nums2 = {1,1};
        for (int i : nums2) {
            System.out.print(i+",");
        }
        System.out.println();
        nextPermutation2(nums2);
        System.out.println();

        for (int i : nums2) {
            System.out.print(i+",");
        }
        System.out.println();

        int[] nums3 = {1,1,5};
        for (int i : nums3) {
            System.out.print(i+",");
        }
        System.out.println();
        nextPermutation(nums3);

        for (int i : nums3) {
            System.out.print(i+",");
        }

    }

    public static void nextPermutation2(int[] A) {
        if(A == null || A.length <= 1) 
            return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) 
        {
            i--; // Find 1st id i that breaks descending order
        }
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) 
            {
                j--;
            }           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }
    
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void reverse(int[] A, int i, int j) {
        while(i < j) 
        {
            swap(A, i++, j--);
        }
    }

    public static void nextPermutation(int[] nums) {
        
        if(nums==null)
            return;

        if(nums.length==1)
            return;
    
        int i=nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i])
        {
            i--;
        }

        if(i>=0)
        {
            int j = nums.length-1;
            while(nums[j]<=nums[i])
            {
                j--;
            }
            int tmp = nums[j];
            nums[j]=nums[i];
            nums[i]=tmp;
       }
       
        i++;
        int j= nums.length-1;
        while(i<nums.length && j>=0 && j>i)
        {
            int t=nums[j];
            nums[j]=nums[i];
            nums[i]=t;
            j--;
            i++;
        }
        return;
    }

    public static void reverse(int[] nums)
    {
        int j=nums.length-1;
        int i=0;
        while(j>i)
        {
            int t=nums[j];
            nums[j]=nums[i];
            nums[i]=t;
            j--;
            i++;
        }

        return;
    }
}
