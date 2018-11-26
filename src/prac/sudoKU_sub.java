package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sudoKU_sub {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.parseInt(br.readLine());

			for (int k = 0; k < num; k++) {

				String[] sd_val = new String[81];

				String s = br.readLine();
				sd_val = s.split(" ");
				int index = 0;

				int[][] mat = new int[9][9];
				for (int i = 0; i < mat[0].length; i++) {
					for (int j = 0; j < mat.length; j++) {
						mat[i][j] = Integer.parseInt(sd_val[index]);
						index++;
					}
				}
				System.out.println(validateSudoKU(mat));
			}

//			long startTime = System.nanoTime();
//
//			long endTime = System.nanoTime();
//			long duration = (endTime - startTime);
//
//			System.out.println("time Taken: " + duration);
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int validateSudoKU(int[][] mat) {
		boolean[][] bool_mat = new boolean[9][9];
		boolean[][] sub_bool_mat = new boolean[3][9];
		boolean[] row_bool = new boolean[9];
//		
//		for(int i=0;i<mat.length;i++)
//		{
//			for(int j=0;j<mat[0].length;j++)
//			{
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (mat[i][j] != 0)
				{
				if (j < 3) {
					if (sub_bool_mat[0][mat[i][j] - 1]) {
						//System.out.println("row " + i + " col " + j);
						return 0;
					} else
						sub_bool_mat[0][mat[i][j] - 1] = true;
				} else if (j > 2 && j < 5) {
					if (sub_bool_mat[1][mat[i][j] - 1]) {
						//System.out.println("row " + i + " col " + j);
						return 0;
					} else
						sub_bool_mat[1][mat[i][j] - 1] = true;
				} else {
					if (sub_bool_mat[2][mat[i][j] - 1]) {
						//System.out.println("2 row " + i + " col " + j);
						return 0;
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
						//System.out.println("1row " + i + "Col " + j);
						return 0;
					}
					if (row_bool[index] || bool_mat[index][j]) {
						//System.out.println("row_bool[index] " + row_bool[index]);
						///System.out.println("bool_mat[index][j] " + bool_mat[index][j]);
						//System.out.println("row " + i + "Col " + j + "index " + (index + 1));
						return 0;
					} else {
						row_bool[index] = true;
						bool_mat[index][j] = true;
					}
				}
			}
			row_bool = new boolean[9];
		}

		return 1;
	}

}
