package Prc_2020_Q4;

public class L79WordSearch {
    public static void main(String[] args) {
        char[][] b = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(b, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        int r = board.length;
        int c = board[0].length;

        boolean[][] isVisted = new boolean[r][c];
        int i = 0;
        // while(i<word.length()){
        char ch = word.charAt(i);
        for (int j = 0; j < r; j++) {
            for (int k = 0; k < c; k++) {
                if (board[j][k] == ch) {
                    if (dfs(board, r, c, j, k, isVisted, word, 0))
                        return true;
                    else {
                        isVisted = new boolean[r][c];
                    }
                }
            }
        }
        // }
        return flag;
    }

    public static boolean dfs(char[][] board, int r_len, int c_len, int j, int k, boolean[][] isVisted, String word,
            int wd_indx) {
        boolean flag = false;
        if (wd_indx > word.length() - 1)
            return true;

        if (j < 0 || k < 0 || j >= r_len || k >= c_len || board[j][k] != word.charAt(wd_indx))
            return false;

        // if (!isVisted[j][k]) {
        isVisted[j][k] = true;
        boolean b1 = dfs(board, r_len, c_len, j + 1, k, isVisted, word, wd_indx + 1);
        if (b1 == true)
            return true;

        boolean b2 = dfs(board, r_len, c_len, j - 1, k, isVisted, word, wd_indx + 1);
        if (b2 == true)
            return b2;

        boolean b3 = dfs(board, r_len, c_len, j, k + 1, isVisted, word, wd_indx + 1);
        if (b3 == true)
            return b3;

        boolean b4 = dfs(board, r_len, c_len, j, k - 1, isVisted, word, wd_indx + 1);
        if (b4 == true)
            return true;

        // }

        return flag;
    }
}
