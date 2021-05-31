package Prc_2020_Q4;

import java.util.Arrays;

public class L931MinimumFallingPathSum {
    public static void main(String[] args) {

        int[][] n = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum2(n));

    }

    public static int minFallingPathSum2(int[][] A) {
        for (int i = 1; i < A.length; ++i)
            for (int j = 0; j < A.length; ++j)
                A[i][j] += Math.min(A[i - 1][j],
                        Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }

    public static int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] memo = new int[r][c];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            memo[0][j] = matrix[0][j];
            if (r == 1) {
                res = Math.min(res, memo[0][j]);
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int v1 = i <= 0 ? Integer.MAX_VALUE : memo[i - 1][j];
                int v2 = (i - 1 < 0 || j - 1 < 0) ? Integer.MAX_VALUE : memo[i - 1][j - 1];
                int v3 = (i - 1 < 0 || j + 1 >= c) ? Integer.MAX_VALUE : memo[i - 1][j + 1];

                int min_val = Math.min(Math.min(v1, v2), v3);
                min_val = min_val == Integer.MAX_VALUE ? 0 : min_val;
                memo[i][j] = min_val + matrix[i][j];

                if (i == r - 1) {
                    res = Math.min(res, memo[i][j]);
                }
            }
        }

        return res;

    }
}
