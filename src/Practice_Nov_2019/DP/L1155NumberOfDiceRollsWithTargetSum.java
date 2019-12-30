package Practice_Nov_2019.DP;

class L1155NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.print(numRollsToTarget(1,6,7));
        System.out.print(numRollsToTarget(2,6,7));
        System.out.print(numRollsToTarget(2,5,10));
        System.out.print(numRollsToTarget(1,2,3));
        System.out.print(numRollsToTarget(30,30,500));
    }

    public static int numRollsToTarget_self(int d, int f, int target) {
        int res =0;


        return res;
    }

    public static int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1]; 
        dp[0][0] = 1;
		//how many possibility can i dices sum up to j;
        for(int i = 1; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                   continue;         //If j is larger than largest possible sum of i dices, there is no possible ways.        
                } else {                      //watch out below condition, or NPE
                    for(int k = 1; k <= f && k <= j ; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD; 
                    }
                }
            }
        }
        return dp[d][target];
    }
}