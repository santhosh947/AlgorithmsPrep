package Practice_Nov_2019.DP;

class L70ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n==1)
            return 1;

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++)
        {
            for(int j=1;j<=2;j++)
            {
              dp[i] += dp[i-j];
            }
        }


        return dp[n];
    }
}