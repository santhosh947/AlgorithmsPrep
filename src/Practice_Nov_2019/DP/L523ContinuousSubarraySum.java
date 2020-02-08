package Practice_Nov_2019.DP;

import java.util.*;

class L523ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] n = {0,1, 0 };
        int[] n2 = { 23, 2, 0, 4, 7 };

         System.out.println(checkSubarraySum(n, -1));
        System.out.println(checkSubarraySum(n2, 6));
        System.out.println(checkSubarraySum(n2, 7));
        System.out.println(checkSubarraySum(n2, 0));

    }

    public static boolean checkSubarraySum1(int[] nums, int k) {
        if (k < 0)
            k *= -1;

        Map<Integer, Integer> hm = new HashMap();
        hm.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int tt = nums[i];
            int rem = Integer.MAX_VALUE;

            rem = k == 0 ? tt : tt % k;
            sum += rem;

            if (hm.containsKey(k - rem)) {
                if (hm.get(k - rem) > 0) {
                    return true;
                }
            }
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);

        }

        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (k < 0)
            k *= -1;
        Map<Integer, Integer> hm = new HashMap();

        hm.put(0, -1);
        int sum = 0;
        int prev = 0;
        int prev_ele = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (k != 0 && temp>k)
                temp = temp % k;

            if(i>0)
                prev_ele=nums[i-1];
            prev = sum;
            sum += temp;
            if (prev != sum) {
                if (hm.containsKey(sum - k)) {
                    if (k != 0 && hm.get(sum - k) > 0) {
                        return true;
                    }
                    if (k == 0 && hm.get(sum - k) > -1)
                        return true;
                }
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
            else {
                if(nums[i]==0){
                        hm.put(0,hm.get(0)+1);
                        if(hm.get(0)>0 && prev_ele==nums[i])
                            return true;
            }
                    
            }
        }

        return false;
    }
}