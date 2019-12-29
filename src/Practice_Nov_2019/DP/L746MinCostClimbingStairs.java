package Practice_Nov_2019.DP;

class L746MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] c = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(c));
    }

    static int min =Integer.MAX_VALUE;

    public static int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)
             return 0;

        if(cost.length == 1)
            return cost[0];

        int[] dp = new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        int n=cost.length;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + (i == n ? 0 : cost[i]);
        }
              
        return dp[n];
    }   
}