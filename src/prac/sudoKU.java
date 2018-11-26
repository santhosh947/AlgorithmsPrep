package prac;

public class sudoKU {
	public static void main(String[] args) {
		// String val = "3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0";
		String val = "3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2 9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1 5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0 7";
		String[] sd_val = new String[81];

		sd_val = val.split(" ");
		int index = 0;

		int[][] mat = new int[9][9];
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = Integer.parseInt(sd_val[index]);
				index++;
			}
		}

		long startTime = System.nanoTime();
		System.out.println(validateSudoKU(mat));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("time Taken: " + duration);

	}

	private static boolean validateSudoKU(int[][] mat) {
		boolean[][] bool_mat = new boolean[9][9];
		boolean[][] sub_bool_mat = new boolean[3][9];
		boolean[] row_bool = new boolean[9];
		
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (mat[i][j] != 0)
				{
				if (j < 3) {
					if (sub_bool_mat[0][mat[i][j] - 1]) {
						System.out.println("row " + i + " col " + j);
						return false;
					} else
						sub_bool_mat[0][mat[i][j] - 1] = true;
				} else if (j > 2 && j < 5) {
					if (sub_bool_mat[1][mat[i][j] - 1]) {
						System.out.println("row " + i + " col " + j);
						return false;
					} else
						sub_bool_mat[1][mat[i][j] - 1] = true;
				} else {
					if (sub_bool_mat[2][mat[i][j] - 1]) {
						System.out.println("2 row " + i + " col " + j);
						return false;
					} else
						sub_bool_mat[2][mat[i][j] - 1] = true;
				}
			}
			}
			if(i%3==2){
			sub_bool_mat = new boolean[3][9];
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (mat[i][j] != 0) {
					int index = mat[i][j] - 1;
					if (index > 8 || index < 0) {
						System.out.println("1row " + i + "Col " + j);
						return false;
					}
					if (row_bool[index] || bool_mat[index][j]) {
						System.out.println("row_bool[index] " + row_bool[index]);
						System.out.println("bool_mat[index][j] " + bool_mat[index][j]);
						System.out.println("row " + i + "Col " + j + "index " + (index + 1));
						return false;
					} else {
						row_bool[index] = true;
						bool_mat[index][j] = true;
					}
				}
			}
			row_bool = new boolean[9];
		}

		return true;
	}

}
