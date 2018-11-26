package prac;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ShortestDistance {
	public static void main(String[] args) throws IOException {

		Scanner stdin = new Scanner(new BufferedInputStream(System.in));

		int N = 0;
		boolean intialized = false;
		int[][] matrix = null;
		int index = 0;

		double minDist = Double.MAX_VALUE;

		while (stdin.hasNext()) {
			String v = stdin.nextLine();
			if (v.split(" ").length == 1 && Integer.valueOf(v) == 0)
				break;
			if (N == 0 && !intialized) {
				N = Integer.parseInt(v);
				matrix = new int[N][2];
				intialized = true;
			} else {

				String[] val = v.split(" ");
				matrix[index][0] = Integer.parseInt(val[0]);
				matrix[index][1] = Integer.parseInt(val[1]);
				index++;
			}

		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double res = findDist(matrix[i][0], matrix[i][1], matrix[j][0],
						matrix[j][1]);
				if (res < minDist) {
					minDist = res;
				}
			}
		}

		if (minDist > 10000) {
			System.out.println("INFINITY");
		} else

		{
			System.out.printf("%.4f", minDist);
		}

	}

	private static double findDist(int x1, int y1, int x2, int y2) {
		double dist = 0;
		dist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
		return dist;
	}
}
