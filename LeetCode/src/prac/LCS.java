package prac;

public class LCS 
{
	public static void main(String[] args)
	{
		String str1 = "abcdef";
		String str2 = "afcde";

		System.out.println("Longest subsequence is " + LCS1(str1,str2));
	}

	public static int LCS1(String str1, String str2)
	{
		int row = str2.length()+1;
		int col = str1.length()+1;
		int[][] k = new int[row][col];

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==0 || j==0)
				{
					k[i][j]=0;
					continue;
				}
				if(str2.charAt(i-1)==str1.charAt(j-1))
				{
					k[i][j]=k[i-1][j-1]+1;
				}
				else
				{
					k[i][j]= (k[i-1][j]>k[i][j-1]) ? k[i-1][j] : k[i][j-1];
				}
			}
		}
		return k[row-1][col-1];
	}
}
