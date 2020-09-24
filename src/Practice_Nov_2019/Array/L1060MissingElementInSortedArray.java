package Practice_Nov_2019.Array;

import java.util.*;

public class L1060MissingElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {4,7,9,10};
       // System.out.println(missingElement(arr,1));

        System.out.println(missingElement_optimal(arr,3));
    }

    public static int missingElement_optimal(int[] nums, int k)
    {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int expected = nums[0] + mid;
            if (nums[mid] - expected < k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return nums[right] + (k - (nums[right] - (nums[0] + right)));
    }

    public static int missingElement(int[] nums, int k) {

        int res=0;
        if(nums==null || nums.length<2)
            return res;

        
        int st = nums[0];
        
        int left =0;
        int right = nums.length-1;

        int diff = nums[right]-nums[left]-right;
        
        if(diff<k)
        {
            k=k-diff;
            st=nums[right];
            return st+k;
        }
       
        while(left<right && k>0)
        {
            int mid = left + (right-left)/2;
            diff = nums[mid]-nums[left]-(mid-left);

            if(diff<k)
            {
                k=k-diff;
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }      

        return nums[left]+k;
        
    }
    
}