package prac;

public class Matrix {

	public static void main(String[] args) {

		int[][] a1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] a2 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] a3 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		printDaigonal(a1);
	}

	private static void printDaigonal(int[][] a1) {
		int row = a1.length;
		int col = a1[0].length;

		int diff = 0;
		while (diff < row || diff < col) {
			int i = diff, j = 0;
			while (i < row && j < col) {
				System.out.println(a1[i][j]);
				i++;
				j++;
			}

			i = 0;
			j = diff;
			if (diff!=0) {
				while (j < col && i < row) {
					System.out.println(a1[i][j]);
					i++;
					j++;
				}
			}
			diff++;
		}
	}
}
