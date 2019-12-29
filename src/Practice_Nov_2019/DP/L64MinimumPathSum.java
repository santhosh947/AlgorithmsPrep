package Practice_Nov_2019.DP;

class L64MinimumPathSum {
    public static void main(String[] args) {
        
    }

    public static int minPathSum(int[][] grid) {
        if(grid==null)
             return 0;
         int r = grid.length;
         int c = grid[0].length;
         
         if(r==0)
             return 0;
         
         for(int j=1;j<c;j++)
         {
             grid[0][j] += grid[0][j-1];
         }
         
         for(int j=1;j<r;j++)
         {
             grid[j][0] += grid[j-1][0];
         }
         
         for(int i=1;i<r;i++)
         {
             for(int j =1;j<c;j++)
             {
                 grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
             }
         }
         return grid[r-1][c-1];
       }
}