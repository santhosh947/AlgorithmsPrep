package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class FindNumOfIslands {
    public static void main(String[] args) {
        char[][] ch = new char[3][3];
        ch[0][0] = 1;
        ch[0][1] = 1;
        ch[0][2] = 1;
        
        ch[1][0] = 0;
        ch[1][1] = 1;
        ch[1][2] = 0;
      
        ch[2][0] = 0;
        ch[2][1] = 0;
        ch[2][2] = 0;
        
        System.out.println(numIslands(ch));
      }
      
      public static int numIslands(char[][] grid) {
        int res = 0;
        
        for(int i=0;i<grid.length;i++)
        {
          for(int j=0;j<grid[0].length;j++)
          {
            if(grid[i][j]==1)
            {
              grid[i][j]=0;
              int j_p = j;
              j_p++;
              //Traverse right 
              while(j_p<grid[0].length && grid[i][j_p]==1)
              {
                grid[i][j_p]=0;
                j_p++;           
              }
              
              int i_p = i;
              i_p++;
              //Traverse down
              while(i_p<grid.length && grid[i_p][j] == 1)
              {
                grid[i_p][j]=0;
                i_p++;
              }
              
              j_p = j;
              j_p--;
              //Traverse left 
              while(j_p>=0 && grid[i][j_p]==1)
              {
                grid[i][j_p]=0;
                j_p--;           
              }
              
              i_p = i;
              i_p--;
              //Traverse down
              while(i_p>=0 && grid[i_p][j] == 1)
              {
                grid[i_p][j]=0;
                i_p--;
              }
              res++;              
            }
          }
        }         
        return res;
      }
}