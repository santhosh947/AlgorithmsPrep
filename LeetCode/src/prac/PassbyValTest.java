package prac;

public class PassbyValTest {

	public static class tt{
		int data;
		tt nt;
		public tt(int i) {
			this.data=i;
		}
		
	}
	public static void main(String[] args) {

		int[] arr = {1,2,3};
		tt t = new tt(100);
		System.out.println(t.data + " " + t.nt);
		changeObj(t);
		System.out.println(t.data + " " + t.nt);
		sort(arr);
		for(int i:arr)
		{
			System.out.println(i);
		}
	}

	private static void changeObj(tt t) {
		tt tp= t;
		tp.nt=new tt(1000);
		tp.data=200;
	}

	private static void sort(int[] arr) {
		arr[0]=10;
		
	}

}
