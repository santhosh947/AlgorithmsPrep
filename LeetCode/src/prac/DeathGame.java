package prac;

import java.util.LinkedList;

public class DeathGame {
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		LinkedList<Integer> queue = new LinkedList<>();
				
		for(int i=0;i<arr.length;i++)
		{
			queue.add(arr[i]);
		}
		int k=3;
		int counter=1;
		while(queue.size()!=1)
		{
			if(counter==k)
			{
				//System.out.println();
				queue.remove();
				counter=1;
			}
			else
			{
				int temp =queue.remove();
				queue.add(temp);
				counter++;
			}
		}
		System.out.println(queue.remove());
		
	}

}
