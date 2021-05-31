package Prc_2020_Q4;

import java.util.*;

public class GamesGiantverticalgame {
    static char[][] grid = new char[7][7];
    static int count = 0;
    static HashMap<Integer, Integer> rowMap = new HashMap<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        // initialise grid with "0
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = '0';
            }
        }
        // GamesGiantVerticalgame g = new GamesGiantVerticalgame();
        Random r1 = new Random();
        char winner = '0';

        for (int i = 0; i < 7; i++) {
            if (winner == 'Y' || winner == 'R') {
                System.out.println("Winner is " + winner);
                break;
            }
            for (int j = 0; j < 7; j++) {

                if (j % 2 == 0) {
                    winner = gamesGiantVerticalgame('Y', 3);// replace 3 with random move r1.nextInt(6)
                } else {
                    winner = gamesGiantVerticalgame('R', 2);// replace 2 with random move r1.nextInt(6)
                }
            }
        }
        if (winner == '0') {
            System.out.println("No Winner ");
        }

    }

    public static char gamesGiantVerticalgame(char player, int col) {
        int n = grid.length;

        if (rowMap.getOrDefault(col, n) >= 0 && col < grid[0].length - 1) {

            if (player == 'Y') {
                rowMap.put(col, rowMap.getOrDefault(col, n) - 1); // store position of row in a map
                grid[rowMap.get(col)][col] = 'Y'; // fill grid position
                count++;
            } else if (player == 'R') {
                rowMap.put(col, rowMap.getOrDefault(col, n) - 1);
                grid[rowMap.get(col)][col] = 'R';
                count++;
            }

            if (count > 6) { // since to win each player should have moved atleast 3 turns, so >(3+3) =7th
                             // turn onwards we can have a winner
                visited = new boolean[7][7];
                if (dfs(grid, player, rowMap.get(col), col, visited) == 4) { // dfs to check if pattern is formed if 4
                                                                             // moves are of the same player
                    return player;
                }
            }
        }

        return '0'; // No Winner
    }

    public static int dfs(char[][] grid, char player, int r, int c, boolean visited[][]) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' || grid[r][c] != player
                || visited[r][c])
            return 0;

        visited[r][c] = true;

        return 1 + dfs(grid, player, r + 1, c, visited) + dfs(grid, player, r - 1, c, visited)
                + dfs(grid, player, r, c - 1, visited) + dfs(grid, player, r, c + 1, visited)
                + dfs(grid, player, r + 1, c + 1, visited) + dfs(grid, player, r - 1, c - 1, visited);
    }
}
