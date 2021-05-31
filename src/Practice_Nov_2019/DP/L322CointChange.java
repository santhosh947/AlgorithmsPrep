package Practice_Nov_2019.DP;

import java.util.Arrays;

class L322CointChange {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };

        // System.out.println(coinChange(coins, 11));

        System.out.println(coinChange2(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        // DP, time complexity: O(ClogC + amount / smallest_coin), C = |coins|
        // space complexity: O(amount)
        // opt[i] = min_j(opt[j]) + 1 if j - i is a denomination in coins
        Arrays.sort(coins);
        int[] opt = new int[amount + 1];
        opt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            opt[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i >= c) {
                    if (opt[i - c] != Integer.MAX_VALUE) {
                        opt[i] = Math.min(opt[i], opt[i - c] + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return opt[amount] == Integer.MAX_VALUE ? -1 : opt[amount];
    }

    public static int coinChange2(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return 0;

        Arrays.sort(coins);
        int[] amt = new int[amount + 1];

        for (int i = 1; i < amt.length; i++) {
            amt[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i >= c) {
                    if (amt[i - c] != Integer.MAX_VALUE)
                        amt[i] = Math.min(amt[i], amt[i - c] + 1);
                } else {
                    break;
                }
            }
        }

        return amt[amount] == Integer.MAX_VALUE ? -1 : amt[amount];
    }
}