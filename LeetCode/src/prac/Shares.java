package prac;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//@source https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java 
public class Shares {
	
	public static void main(String[] args){
		int[] shares= new int[]{2,5,7,1,4,3,1,3};
		int k =3;
		
		int maxprofit = maxProfit(k,shares);
		System.out.println(maxprofit);

		//		printMatrix(arr);
		
		//printDetails(arr,row,col,shares);
	}
	
	private static int maxProfit(int k, int[] shares) {
		int[][] arr = new int[k+1][shares.length];

		for(int j=0;j<arr[0].length;j++)
		{
			arr[0][j]=0;
		}
		
		int row=arr.length;
		int col=arr[0].length;
		int maxdiff=Integer.MIN_VALUE;
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				maxdiff=Math.max(maxdiff, arr[i-1][j-1]-shares[j-1]);
				arr[i][j]=Math.max(shares[j]+maxdiff,arr[i][j-1]);
			}
			maxdiff=Integer.MIN_VALUE;
		}
		
		//printDetails(arr,row,col,shares);

		print(arr,shares);
		return arr[k][col-1];
	}

	private static void print(int[][] arr, int[] shares) {
		int row = arr.length;
		int col=arr[0].length;
		int i=row-1;
		int j=col-1;
		
		Deque<Integer> temp = new ArrayDeque<>();
		temp.push(1);
		temp.push(2);
		temp.push(3);
		temp.push(4);
		
		while(!temp.isEmpty())
		{
			System.out.println(temp.pop());
		}
		
		Deque<Integer> stk = new ArrayDeque<>();
		
		while(true)
		{
			if(i==0 || j==0)
				break;
			else
			{
				if(arr[i][j]==arr[i][j-1])
				{
					j=j-1;
				}
				else
				{
					stk.push(shares[j]);
					int maxdiff = arr[i][j]-shares[j];
					for(int k=j-1;k>=0;k--)
					{
						if(arr[i-1][k]-shares[k]==maxdiff)
						{
							i=i-1;
							j=k;
							stk.push(shares[j]);
							break;
						}
					}
				}
			}			
		}
		
		while(!stk.isEmpty())
		{
			System.out.println("Brought at " + stk.pop());
			System.out.println("sell at " + stk.pop());		
		}
				
	}

	private static void printDetails(int[][] arr,int row,int col,int[] shares) {
		Stack op = new Stack();
		
		int r=row-1;
		int c=col-1;
		while(r>0 || c>0)
		{
			
			if(arr[r][c]>arr[r][c-1])
			{
				int diff = arr[r][c]-shares[c];
				op.add(c);
				op.add(c-1);
			}
			else
			{
				c=c-1;
			}
		}
		

		for(int i=row-1;i>=0;i--)
		{
			for(int j=col-1;j>=0;j--)
			{
				if(arr[i][j]>arr[i][j-1])
				{
					op.add(j);
					op.add(j-1);
				    System.out.println("stock sold on " +j + " at cost " + shares[j]);
					//System.out.println("stock brought at " + (j-1) + " at cost " + shares[j-1]);					
				}
				else
				{
					
				}
			}
		}
	}

	public static void printMatrix(int[][] arr)
	{
		int row=arr.length;
		int col = arr[0].length;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
