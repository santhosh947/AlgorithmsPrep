package Practice_Nov_2019.Array;

import java.util.*;

class L169MajorityElement {
    public static void main(String[] args) {
        int[] n = {3,2,3};
        System.out.println(majorityElement2(n));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            int t = hm.getOrDefault(nums[i],0)+1;
            if(t>nums.length/2)
                return nums[i];

            hm.put(nums[i],t);
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}