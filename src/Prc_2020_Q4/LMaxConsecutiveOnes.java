package Prc_2020_Q4;

public class LMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] in1 = { 0, 1, 0, 0, 1, 1, 0 };
        int[] in2 = { 0, 0, 0, 1, 0, 1 };

        System.out.println(findMaxZeroCount_geeks(in1, 6));

    }

    // not optimal O(n*2)
    public static int findMaxZeroCount_geeks(int arr[], int n) {
        // Initialize max_diff = maximum of (Count of 0s -
        // count of 1s) for all subarrays.
        int max_diff = 0;

        // Initialize count of 0s in original array
        int orig_zero_count = 0;

        // Consider all Subarrays by using two nested two
        // loops
        for (int i = 0; i < n; i++) {
            // Increment count of zeros
            if (arr[i] == 0)
                orig_zero_count++;

            // Initialize counts of 0s and 1s
            int count1 = 0, count0 = 0;

            // Consider all subarrays starting from arr[i]
            // and find the difference between 1s and 0s.
            // Update max_diff if required
            for (int j = i; j < n; j++) {
                if (arr[j] == 1)
                    count1++;
                else
                    count0++;
                max_diff = Math.max(max_diff, count1 - count0);
            }
        }

        // Final result would be count of 0s in original
        // array plus max_diff.
        return orig_zero_count + max_diff;
    }

    public static int findMaxZeroCount(int arr[], int n) {
        int cnt_zero = 0;
        int st_arr = -1;
        int end_arr = -1;
        int max_arr_size = 0;
        boolean inSubArray = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt_zero++;
                if (inSubArray) {
                    inSubArray = false;
                    if (end_arr - st_arr + 1 > max_arr_size) {
                        max_arr_size = end_arr - st_arr + 1;
                    }
                    end_arr = -1;
                    st_arr = -1;
                }
            } else {
                if (st_arr == -1 && end_arr == -1) {
                    st_arr = i;
                    end_arr = i;
                } else {
                    end_arr = i;
                }
                inSubArray = true;
            }
        }

        if (inSubArray) {
            if (end_arr - st_arr > max_arr_size) {
                max_arr_size = end_arr - st_arr;
            }
        }

        return cnt_zero + max_arr_size;
    }

}
