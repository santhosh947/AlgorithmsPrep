package Prac2;

public class SortedMatrixSearch2 {
	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int[][] m2 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int[][] m = { { 1 } };
		System.out.println(searchMatrix(m2, 5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;

		int r = matrix.length;
		if (r == 0)
			return false;

		int c = matrix[0].length;

		if (c == 0)
			return false;

		if (matrix[0][0] <= target && matrix[r - 1][c - 1] >= target) {
			for (int i = 0; i < r; i++) {
				if (matrix[i][c - 1] >= target && matrix[i][0] <= target) {
					if (search(matrix[i], 0, c - 1, target))
						return true;
				}
			}
		} else
			return false;

		return false;
	}

	public static boolean search(int[] m, int s, int e, int t) {
		if (m[s] == t || m[e] == t)
			return true;

		else if (s == e)
			return false;

		else if (m[s] > t || m[e] < t)
			return false;

		else {
			int mid = (s + e) / 2;
			if (m[mid] == t)
				return true;
			if (m[mid] > t && m[s] < t)
				return search(m, s, mid - 1, t);
			else
				return search(m, mid + 1, e, t);
		}
	}
}
