package Prc_2020_Q4;

import java.util.*;

public class L983MinimumCostForTickets {
    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };

        System.out.println(mincostTickets2(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        Set<Integer> days_exist = new HashSet<Integer>();
        for (int i : days) {
            days_exist.add(i);
        }

        for (int i = 1; i < dp.length; i++) {
            if (days_exist.contains(i)) {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], dp[Math.max(0, i - 7)] + costs[1]),
                        dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static int mincostTickets2(int[] days, int[] costs) {
        int[] dp = new int[30];
        int d = 0; // d means the index of next travel day
        int lastday = days[days.length - 1];

        for (int i = days[0]; i <= lastday; i++) {
            if (i != days[d])
                dp[i % 30] = dp[(i - 1) % 30]; // we don't have thid day for travel, price as yesterday
            else { // i == days[d]
                dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0],
                        Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1], dp[Math.max(i - 30, 0) % 30] + costs[2]));
                d++;
            }
        }

        return dp[lastday % 30];
    }
}
