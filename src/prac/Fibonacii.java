package prac;


public class Fibonacii {
	static long[] fibCache = new long[200];

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		/*
		 * for (int i = 0; i < 40; i++) { System.out.println(fibonacii(i)); }
		 */
		System.out.println(fibonacii(40));

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("time Taken: " + duration);

		long startTime2 = System.nanoTime();

		System.out.println(fibonaciiWithCache(40));

		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);

		System.out.println("time Taken: " + duration2);
		
		System.out.println((float)(duration2/duration));

	}

	private static long fibonaciiWithCache(int i) {

		if (i <= 1) {
			fibCache[i] = 1;
		}
		if (fibCache[i] == 0)
			fibCache[i] = fibonaciiWithCache(i - 1) + fibonaciiWithCache(i - 2);

		return fibCache[i];
	}

	private static int fibonacii(int i) {

		if (i <= 1) {
			return 1;
		}
		return fibonacii(i - 1) + fibonacii(i - 2);
	}
}
