package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class FindNumOfIslands {
    public static void main(String[] args) {
        char[][] ch = new char[3][3];
        ch[0][0] = '1';
        ch[0][1] = '1';
        ch[0][2] = '1';
        
        ch[1][0] = '0';
        ch[1][1] = '1';
        ch[1][2] = '0';
      
        ch[2][0] = '0';
        ch[2][1] = '0';
        ch[2][2] = '0';
        
        System.out.println(numIslands(ch));

        ch = new char[4][5];
        ch[0][0] = '1';
        ch[0][1] = '1';
        ch[0][2] = '0';
        ch[0][3] = '0';
        ch[0][4] = '1';
        
        ch[1][0] = '0';
        ch[1][1] = '1';
        ch[1][2] = '0';
        ch[1][3] = '1';
        ch[1][4] = '1';
           
        ch[2][0] = '1';
        ch[2][1] = '0';
        ch[2][2] = '0';
        ch[2][3] = '1';
        ch[2][4] = '1';

        ch[3][0] = '1';
        ch[3][1] = '0';
        ch[3][2] = '0';
        ch[3][3] = '0';
        ch[3][4] = '0';

        System.out.println(numIslands_8D(ch));

        
      }
      
      public static int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length==0)
            return '0';
        
        for(int i=0;i<grid.length;i++)
        {
          for(int j=0;j<grid[0].length;j++)
          {
            if(grid[i][j]=='1')
            {
              res++;
              dfs(grid,i,j);
            }
          }
        }
        
        return res;
      }
      
      public static void dfs(char[][] g,int r, int c)
      {
        if(r<0 || r >= g.length || c<0 || c>= g[0].length || g[r][c]=='0')
          return;
        
        g[r][c]= '0';
        dfs(g,r+1,c);
        dfs(g,r-1,c);
        dfs(g,r,c+1);
        dfs(g,r,c-1);
      }


      public static int numIslands_8D(char[][] grid) {
        int res = 0;
        if(grid.length==0)
            return '0';
        
        for(int i=0;i<grid.length;i++)
        {
          for(int j=0;j<grid[0].length;j++)
          {
            if(grid[i][j]=='1')
            {
              res++;
              dfs2(grid,i,j);
            }
          }
        }
        
        return res;
      }
      
      public static void dfs2(char[][] g,int r, int c)
      {
        if(r<0 || r >= g.length || c<0 || c>= g[0].length || g[r][c]=='0')
          return;
        
        g[r][c]= '0';
        dfs2(g,r+1,c);
        dfs2(g,r-1,c);
        dfs2(g,r,c+1);
        dfs2(g,r,c-1);
        dfs2(g,r+1,c+1);
        dfs2(g,r-1,c-1);
        dfs2(g,r+1,c-1);
        dfs2(g,r-1,c+1);
      }
}