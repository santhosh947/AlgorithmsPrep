package Practice_Nov_2019.Array;

import java.util.*;

class L64MinimumPathSum {
    public static void main(String[] args) {
        int[][] g = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(g));
    }

    public static int minPathSum(int[][] g) {
        if(g==null|| g.length==0)
            return 0;

       int r = g.length;
       int c = g[0].length;
       int[][] dp = new int[r][c];
       dp[0][0]=g[0][0];
       for(int i=1;i<r;i++)
       {
           dp[i][0]=dp[i-1][0]+g[i][0];
       }

       for(int i=1;i<c;i++)
       {
           dp[0][i]=dp[0][i-1]+g[0][i];
       }

       for(int i=1;i<r;i++)
       {
           for(int j=1;j<c;j++)
           {
               dp[i][j]=g[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
           }
       }
        
        return dp[r-1][c-1];
    }

    private static int res;
    public static int minPathSum_rec(int[][] g) {
        res = 0;
        if(g==null|| g.length==0)
            return res;

        res = Integer.MAX_VALUE;
        dfs(g,0,0,0);
        return res;
    }

    private static void dfs(int[][] g, int i,int j, int sum){
        int r = g.length-1;
        int c = g[0].length-1;
        if(i<0 || j<0 || i>r || j>c)
        {
            return;
        }
        if(i==r && j==c)
        {
            res = Math.min(res,sum+g[i][j]);
            return;
        }
        dfs(g,i+1,j,sum+g[i][j]);
        dfs(g,i,j+1,sum+g[i][j]);
        return;
    }
}