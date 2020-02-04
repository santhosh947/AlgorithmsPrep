package Practice_Nov_2019.DP;

class L647PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("fdsklf"));

        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("aba"));

    }

    public static int countSubstrings(String s) {
        if (s == null)
            return 0;

        if (s.length() == 1)
            return 1;
        int len = s.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for(int j=i;j>=0;j--)
            {
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[i-1][j+1]))
                {
                    dp[i][j]=true;
                }
                if(dp[i][j])
                    res++;

                 
            }
        }
        return res;
    }

    public static int countSubstrings_self_notworking(String s) {
        if (s == null)
            return 0;

        if (s.length() == 1)
            return 1;
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int diff = 1; diff < len; diff++) {
            for (int j = 0; j < len - diff; j++) {
                int k = j + diff;

                if (s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = dp[j][k - 1] + dp[j + 1][k] + 1 - dp[j + 1][k - 1];
                } else {
                    dp[j][k] = Math.max(dp[j][k - 1], dp[j + 1][k]) + 1;
                }
            }
        }

        return dp[0][len - 1];
    }
}