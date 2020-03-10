package Practice_Nov_2019.Recurrsions;

import java.util.*;

class FBPrac2 {

    private static class point {
        int i;
        int j;
        public point(int a,int b)
        {
            i=a;
            j=b;
        }
    }
    private static int dis;

    public static void main(String[] args) {
        int[][] in = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};

        point p = new point(0,1);
        point des = new point(2,2);
        int c=-1;
        dis=Integer.MAX_VALUE;
        //System.out.println(findDist(p, des,c, in));
        int[][] g2 = in;

      //  System.out.println(dfs(p.i,p.j, des.i,des.j,c, g2, new HashSet()));

       // System.out.println(dfs(p.i,p.j, des.i,des.j,c, g2));
        System.out.println(shortestDistance(in));       
      //  System.out.println(shortestDistance2(in));        
 
    }

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) 
            return 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        
        int row  = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[] {i,j});

                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;
                    
                    while (!myQueue.isEmpty()) {
                        int qSize = myQueue.size();
                        for (int q = 0; q < qSize; q++) {
                            int[] curr = myQueue.poll();
                            
                            for (int k = 0; k < 4; k++) {
                                int nextRow = curr[0] + shift[k];
                                int nextCol = curr[1] + shift[k + 1];
                                
                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                        //The shortest distance from [nextRow][nextCol] to thic building
                                        // is 'level'.
                                        distance[nextRow][nextCol] += level;
                                        reach[nextRow][nextCol]++;
                                        
                                        isVisited[nextRow][nextCol] = true;
                                        myQueue.offer(new int[] {nextRow, nextCol});
                                    }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
        
        
    }

    public static int shortestDistance2(int[][] g) {
        HashSet<point> hs = new HashSet();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[0].length;j++)
            {
                if(g[i][j]==1)
                {
                    hs.add(new point(i,j));
                }
            }
        }
        int res =0;

        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[0].length;j++)
            {
                if(g[i][j]==0)
                {
                    Iterator it = hs.iterator();
                    res =0;
                    while(it.hasNext())
                    {
                        point p =  (point)it.next();
                       // int[][] g2 = g;
                        res += dfs(i,j,p.i,p.j,0,g, new boolean[g.length][g[0].length]);
                    }
                }
                if(res>0)
                   min=Math.min(res,min);
            }
        }
        
        return min== Integer.MAX_VALUE ? -1 : min;
    }

    private static int dfs(int i, int j, int i2, int j2, int c, int[][] g, boolean[][] visited) {
        if(i<0 || j<0 || i>g.length-1 || j>g[0].length-1)
        {
            return 0;
        }
        if(g[i][j]==1 && i==i2 && j==j2)
        {
            c++;
            dis = Math.min(c,dis);
            return dis;
        }
        if(g[i][j]==1)
        {
            return 0;
        }
       // g[i][j]=1;
       visited[i][j]=true;

        if(i<g.length-1 && !visited[i+1][j] && (g[i+1][j]==0 || g[i+1][j]==1))
        {
           dfs(i+1,j,i2,j2,c+1,g, visited);
        }

        if(j<g[0].length-1 && !visited[i][j+1]&& (g[i][j+1]==0 || g[i][j+1]==1)) {
            dfs(i,j+1,i2,j2,c+1,g,visited);
        }

        if(j>0 && !visited[i][j-1] && (g[i][j-1]==0 || g[i][j-1]==1)){
            dfs(i,j-1,i2,j2,c+1,g, visited);
        }
        if(i>0 && !visited[i-1][j] &&(g[i-1][j]==0 || g[i-1][j]==1)){
            dfs(i-1,j,i2,j2,c+1,g,visited);
        }      

        return dis;
    }

    private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    private static int findDist(point p, point des,int c, int[][] g) {
        if(g[p.i][p.j]==1 && p==des)
        {
            c++;
            dis = Math.min(c,dis);
            return c;
        }
        if(g[p.i][p.j]==1)
            return Integer.MAX_VALUE;

        for(int i=0;i<dirs.length;i++)
        {
            int a1 = p.i+dirs[i][0];
            int b1 = p.j+dirs[i][1];
            if(g[a1][b1]==0 || g[a1][b1]==1)
            {
                findDist(p, des, c+1, g);
            } else {
                return 0;
            }
        }
        return dis;        
    }

    
}