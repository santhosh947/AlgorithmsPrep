package prac;

public class TowerOfHanoi {

	public static void main(String[] args) {
		solve(3, "A", "B", "C");
	}

	private static void solve(int i, String start, String aux, String end) {
		if(i==1)
		{
			System.out.println(start + "->" + end);
		}
		else
		{
			solve(i-1, start, end,aux);
			System.out.println(start+"->"+end);
			solve(i-1, aux, start, end);
		}

	}

}
