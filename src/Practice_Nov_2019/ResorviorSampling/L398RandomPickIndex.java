package Practice_Nov_2019.ResorviorSampling;

import java.util.*;

class L398RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = new int[] { 11, 30, 2, 30, 30, 30, 6, 2, 62, 62 };

        RandomPickIndex n = new RandomPickIndex(nums);

        // System.out.println(n.pick(3));
        // System.out.println(n.pick(2));
        // System.out.println(n.pick(3));
        // System.out.println(n.pick(1));

        n.maxRandomIndex(nums);

    }

    private static class RandomPickIndex {
        int[] nums;
        Random rnd;

        public RandomPickIndex(int[] nums) {
            this.nums = nums;
            this.rnd = new Random();
        }

        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target)
                    continue;
                if (rnd.nextInt(++count) == 0)
                    result = i;
            }

            return result;
        }

        public void maxRandomIndex(int[] nums) {
            Random random = new Random();

            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                    count = 1;
                } else if (nums[i] == max) {
                    count++;

                    // probability of 1/count
                    if (random.nextInt() %count== 0) {
                        maxIndex = i;
                    }
                }

                System.out.print(maxIndex + ", Value: "+nums[maxIndex]);
                System.out.println();
            }
        }
    }
}