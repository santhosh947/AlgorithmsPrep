package Prac2;

public class ArrayReversal {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		print(arr);
		reverse(arr);
		System.out.println();
		print(arr);
	}
	public static void print(int[] arr)
	{
		for(int i=0;i <arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void reverse(int[] arr)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			int t = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length-1-i] = t;
		}
	}
}
