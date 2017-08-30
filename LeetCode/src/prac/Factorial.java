package prac;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(findFact(8));
	}
	
	public static int findFact(int a)
	{
		if(a<=1)
			return 1;
		
		return findFact(a-1) + findFact(a-2);
	}
}
//0 1 1 2 3 5 8