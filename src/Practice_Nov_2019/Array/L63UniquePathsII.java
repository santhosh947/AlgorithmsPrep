package Practice_Nov_2019.Array;

class L63UniquePathsII {
    public static void main(String[] args) {
        int[][] g={{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
        int[][] g2={{0,0,0},{0,0,0},{0,0,0}};

        int[][] g3={{0,1}};

        System.out.println(uniquePaths(3,7));
        long start = System.currentTimeMillis();

        System.out.println(uniquePathsWithObstacles3(g2));
        System.out.println(uniquePathsWithObstacles(g3));


        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " + (end - start) + "ms");
    }
    //private static int[][] dirs = {{1,0},{0,1}};
    public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
		int n = obstacleGrid.length - 1;
		int m = obstacleGrid[0].length - 1;

		int[][] track = new int[n + 1][m + 1];
		track[n][m] = obstacleGrid[n][m] == 1 ? 0 : 1;

		for (int i = n - 1; i >= 0; i--) {
			track[i][m] = obstacleGrid[i][m] == 1 ? 0 : track[i + 1][m];
		}
		for (int i = m - 1; i >= 0; i--) {
			track[n][i] = obstacleGrid[n][i] == 1 ? 0 : track[n][i + 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1) {
					track[i][j] = 0;
				} else {
					track[i][j] = track[i][j + 1] + track[i + 1][j];
				}
			}
		}

		return track[0][0];
	}
    public static int uniquePathsWithObstacles2(int[][] g) {
        if(g==null || g.length==0 || g[0][0]==1)
            return 0;
        
        int[][] dp = new int[g.length][g[0].length];
        int r = g.length;
        int c = g[0].length;
        dp[0][0]=1;
        for(int i=0;i<r;i++)
        {
           // int i_id= i-1;

            for(int j=0;j<c;j++)
            {
              //  int j_id = j-1;
            if(i==0 && j==0)
                dp[i][j]=1;
            else
            {
                if(g[i][j]==1)
                    dp[i][j]=0;
                else 
                   dp[i][j]=((i-1>=0 &&g[i-1][j]==0)?dp[i-1][j]:0)+((j-1>=0&&g[i][j-1]==0)?dp[i][j-1]:0);    
            }            



            }
        }

        return dp[r-1][c-1];
    }
    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        if(m<n)
            return uniquePaths(n,m);
        
        
        n--;
        m--;       
       
        long res=1;
        int j =1;
        for(int i=m+1;i<=m+n;i++,j++)
        {
            res*=i;
            res/=j;
        }
        return (int)res;
    }

    private static int res;
    public static int uniquePathsWithObstacles(int[][] g) {
        if(g==null || g.length==0 || g[0][0]==1)
            return 0;
        
        res=0;
        dfs(g,0,0);
        return res;
    }
    private static void dfs(int[][] g, int i, int j)
    {
        int r = g.length-1;
        int c = g[0].length-1;
        if(i<0 || i>r || j<0 || j>c || g[i][j]==1)
            return;
        if(i==r && j==c && g[i][j]==0)
        {
            res++;
            return;
        }
        
        
        dfs(g,i+1,j);
        dfs(g,i,j+1);
        return;
        
    }
}