package Prac2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Point
{
	int i;
	int j;
	public Point(int i, int j)
	{
		this.i = i;
		this.j= j;
	}
}
public class maxIsland {
	public static int commonCt = 0;

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 },
				{ 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1 } };
		int[][] m2 = { { 1,1 } };
		System.out.println(maxAreaOfIsland2(mat));
	}

	public static int maxAreaOfIsland2(int[][] grid) {
		int maxLen = 0;
		int tempLen = 0;
		int rowLen = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					tempLen=0;
					tempLen+=processQueue(grid, i, j);
				}
				if(maxLen<tempLen)
					maxLen=tempLen;
			}
		}
		return maxLen;
	}

	private static int processStack(int[][] grid, int i, int j) {
		int ct=0;
		int rowLen = grid.length;
		int col = grid[0].length;
		Stack st = new Stack();
		if(grid[i][j]==1)
		{
			st.push(new Point(i,j));
			grid[i][j]=-1;
		}
		while(!st.isEmpty())
		{
			ct++;
			Point p = (Point) st.pop();
			int r = p.i;
			int c = p.j;
			//Traverse right
			if(c+1<col && grid[r][c+1]==1)
			{
				st.add(new Point(r,c+1));
				grid[r][c+1]=-1;
			}
			
			//Traverse left
			if(c-1>=0 && grid[r][c-1]==1)
			{
				st.add(new Point(r,c-1));
				grid[r][c-1]=-1;
			}
			
			//Traverse up
			if(r-1>=0 && grid[r-1][c]==1)
			{
				st.add(new Point(r-1,c));
				grid[r-1][c]=-1;
			}
			
			//Traverse down
			if(r+1<rowLen && grid[r+1][c]==1)
			{
				st.add(new Point(r+1,c));
				grid[r+1][c]=-1;
			}
		}
		return ct;
	}
	
	private static int processQueue(int[][] grid, int i, int j) {
		int ct=0;
		int rowLen = grid.length;
		int col = grid[0].length;
		Queue st = new LinkedList<>();
		if(grid[i][j]==1)
		{
			st.add(new Point(i,j));
			grid[i][j]=-1;
		}
		while(!st.isEmpty())
		{
			ct++;
			Point p = (Point) st.poll();
			int r = p.i;
			int c = p.j;
			//Traverse right
			if(c+1<col && grid[r][c+1]==1)
			{
				st.add(new Point(r,c+1));
				grid[r][c+1]=-1;
			}
			
			//Traverse left
			if(c-1>=0 && grid[r][c-1]==1)
			{
				st.add(new Point(r,c-1));
				grid[r][c-1]=-1;
			}
			
			//Traverse up
			if(r-1>=0 && grid[r-1][c]==1)
			{
				st.add(new Point(r-1,c));
				grid[r-1][c]=-1;
			}
			
			//Traverse down
			if(r+1<rowLen && grid[r+1][c]==1)
			{
				st.add(new Point(r+1,c));
				grid[r+1][c]=-1;
			}
		}
		return ct;
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxLen = 0;
		int rowLen = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					commonCt = 0;
					dfs2(grid, i, j);
				}
				if (maxLen < commonCt) {
					maxLen = commonCt;
				}
			}
		}

		return maxLen;
	}

	private static void dfs2(int[][] grid, int i, int j) {
		// Stack st = new Stack();
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
				|| grid[i][j] == 0)
			return;

		grid[i][j] = 0;
		commonCt++;
		dfs2(grid, i, j + 1);
		dfs2(grid, i, j - 1);
		dfs2(grid, i + 1, j);
		dfs2(grid, i - 1, j);

	}

	private static int dfs(int[][] grid, int i, int j, int ct) {
		// Stack st = new Stack();
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
				|| grid[i][j] == 0)
			return ct;

		grid[i][j] = 0;
		ct++;
		dfs(grid, i, j + 1, ct);
		dfs(grid, i, j - 1, ct);
		dfs(grid, i + 1, j, ct);
		dfs(grid, i - 1, j, ct);

		return ct;

	}

}
