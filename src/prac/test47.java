package prac;

import java.util.Arrays;
import java.util.List;

public class test47 {
	public static void main(String[] args) {
			
		String e= ""+2+1+1+1;
		int a=(int) Math.pow(2,10);
		System.out.println(a);
	}
	

	public static int solution(int[] A) {
		// write your code in Java SE 8
		int[] t=new int[A.length];
		int r = 1;
		for (int i = 0; i < A.length; i++) {
			if(A[i]>0)
			{
			 t[A[i]-1]=1;
			}
		}
		for(int i=0;i<t.length;i++)
		{
			if(t[i]==0)
				return i+1;
		}
		return t.length+1;
	}
}