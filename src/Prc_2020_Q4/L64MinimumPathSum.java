package Prc_2020_Q4;

public class L64MinimumPathSum {
    public static void main(String[] args) {
        int[][] g = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(g));
    }

    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] memo = new int[r][c];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else {

                    int v1 = i - 1 < 0 ? Integer.MAX_VALUE : memo[i - 1][j];
                    int v2 = j - 1 < 0 ? Integer.MAX_VALUE : memo[i][j - 1];

                    memo[i][j] = Math.min(v1, v2) + grid[i][j];
                }
            }
        }

        return memo[r - 1][c - 1];
    }
}
