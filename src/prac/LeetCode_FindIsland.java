package prac;

public class LeetCode_FindIsland {
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
        int row=grid.length;
        if(row==0)
            return 0;
        int col=grid[0].length;
        int ct=0;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    ct++;
                    dfs(grid,i,j);
                }
            }
        }
        
        return ct;
        
    }
    public static void dfs(char[][] grid, int r, int c)
    {
        if(r<0||r>=grid.length || c <0 || c>= grid[0].length || grid[r][c]=='0')
            return;
        
        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
            
    }
}
