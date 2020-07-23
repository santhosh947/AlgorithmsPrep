package Old_files;
public class TicTacToe {
    private int[][] rowCount;
    private int[][] colCount;
    private int[][] diagCount;
    private int n = 0;

    public TicTacToe(int n) {
        this.n = n;
        rowCount = new int[2][n];
        colCount = new int[2][n];
        diagCount = new int[2][2];
    }

    public int move(int row, int col, int player) {
        int playerIndex = player == 1 ? 0 : 1;
        
        rowCount[playerIndex][row]++;
        if (rowCount[playerIndex][row] == n) return player;
        
        colCount[playerIndex][col]++;
        if (colCount[playerIndex][col] == n) return player;
        
        if (row == col) diagCount[playerIndex][0]++;
        if (diagCount[playerIndex][0] == n) return player;
        
        if (row + col == n - 1) diagCount[playerIndex][1]++;
        if (diagCount[playerIndex][1] == n) return player;
        
        return 0;
    }
}