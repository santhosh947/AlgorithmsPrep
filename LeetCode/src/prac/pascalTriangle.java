package prac;

import java.util.Scanner;

public class pascalTriangle {
	static int[][] temp;
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter the number of rows to print: ");
	    int rows = scanner.nextInt();
	    System.out.println("Pascal Triangle:");
	      long startTime = System.currentTimeMillis();
	      temp= new int[rows][rows];
		    print(rows);

	    long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("*****************************************");
	      System.out.println(elapsedTime);
	    scanner.close();
	  }

	  public static void print(int n) {
	    for (int i = 0; i < n; i++) {
	      for (int k = 0; k < n - i; k++) {
	        System.out.print(" "); // print space for triangle like structure
	      }
	      for (int j = 0; j <= i; j++) {
	        temp[i][j]=pascal(i, j);
	        System.out.print(temp[i][j] + " ");
	      }
	      System.out.println();
	    }
	  }

	  public static int pascal(int i, int j) {
	    if (j == 0 || j == i) {
	      return 1;
	    } else {
	    	int l;
	    	if(temp[i-1][j-1]!=0)
	    	{
	    		l=temp[i-1][j-1];
	    	}
	    	else
	    	{
	    		l=pascal(i-1, j-1);
	    	}
	    	
	    	int r;
	    	if(temp[i-1][j]!=0)
	    	{
	    		r=temp[i-1][j];
	    	}
	    	else
	    	{
	    		r=pascal(i-1, j);
	    	}
	      return l+r;
	    }
	  }
}
