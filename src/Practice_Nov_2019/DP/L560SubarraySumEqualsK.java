package Practice_Nov_2019.DP;

import java.util.HashMap;
import java.util.Map;

class L560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5};
        System.out.println(subarraySum(n, 9));

    }

    public static int subarraySum_self(int[] nums, int k) {
        int[] tot = new int[nums.length + 1];
        int prev = 1;
        tot[1] = nums[0];

        Map<Integer, Integer> hs = new HashMap();
        hs.put(tot[1], 1);

        for (int i = 2; i < nums.length + 1; i++) {
            tot[i] = tot[prev] + nums[i - 1];
            if (hs.containsKey(tot[i])) {
                int kd = (int) hs.get(tot[i]) + 1;
                hs.put(tot[i], kd);
            } else {
                hs.put(tot[i], 1);
            }
            prev++;
        }

        int res = 0;
        int tar = k;
        for (int i = 0; i < nums.length; i++) {
            tar += tot[i];
            if (hs.containsKey(tar)) {
                res += (int) hs.get(tar);
            }
            tar = k;
        }

        return res;
    }

    public static int subarraySum_sub(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap();
        hm.put(0,1);
          int res =0;
          int sum=0;
  
         for(int i=0;i<nums.length;i++)
         {
             sum+=nums[i];
             if(hm.containsKey(sum-k))
             {
                 res += hm.get(sum-k);
             }
             hm.put(sum, hm.getOrDefault(sum,0)+1);
         }
        
        return res;
      }


    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }

    public static int subarraySum_ap2(int[] nums, int k)
    {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
    public static int subarraySum_ap1(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

   
}