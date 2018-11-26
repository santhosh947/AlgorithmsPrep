package Prac2;

import java.util.LinkedList;
import java.util.Queue;

public class SoliderKilling {
	public static void main(String[] args) {
		System.out.println(luckyPerson(5));
		System.out.println(luckyPerson(100));
	}
	
	public static int luckyPerson(int n)
	{
		if(n==0 || n==1)
			return n;
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			q.add(i+1);
		}
		
		while(q.size()>1)
		{
			int killer = q.remove();
			q.remove();
			q.add(killer);
		}
		
		return q.remove();
	}
}
