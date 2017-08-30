package prac;

public class HackerRank {

	public static void main(String[] args) {
		/*FoodFactory myfoods = new FoodFactory();
		Food f1= myfoods.getFood("FastFood");
		Food f2= myfoods.getFood("Fruit");
		System.out.println("My name is: " + f1.getClass().getName());
		System.out.println("My name is: " + f2.getClass().getName());
		System.out.println("super class is " + f1.getClass().getSuperclass().getName());
		
		f1.serveFood();
		f2.serveFood();
		*/
		int[] arr = {1,2,3};
		int ddd = Integer.parseInt("1");
		String st1="1st Mar 1984";
		String[] ss= st1.split(" ");
//		for(String s:ss)
//		{
//			System.out.println(s);
//		}
		
		System.out.println(ss[0].substring(0, ss[0].length()-2));
		String tt = ss[0].substring(0, ss[0].length()-2);
		String temp = (tt.length()==1 ? "0"+tt : tt);
		System.out.println(temp);
		System.out.println(arr.length);

		
	}
}
