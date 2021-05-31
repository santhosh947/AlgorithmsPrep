package Prc_2020_Q4;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        System.out.println(subarraySum(a, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        // Set<Integer> hs = new HashSet<Integer>();
        Map<Integer,Integer> hs = new HashMap<Integer,Integer>();

        hs.put(0, 1);

        int res = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int residual = sum - k;

            if (hs.containsKey(residual)) {
                res += hs.get(residual);
            }

            hs.put(sum, hs.getOrDefault(sum, 0) + 1);

        }

        return res;
    }
}
