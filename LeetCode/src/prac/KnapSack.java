package prac;

public class KnapSack {

	public static void main(String[] args) {
		int[] capacity = { 2, 2, 1 };
		int[] value = { 3, 1, 3 };

		int maxAllowedCapacity = 4;

		findMaxKnapSackProblem(capacity, value, maxAllowedCapacity);
	}

	private static void findMaxKnapSackProblem(int[] capacity, int[] value,
			int maxAllowedCapacity) {

		int[][] M = new int[value.length + 1][maxAllowedCapacity + 1];
		for (int i = 1; i < M.length; i++) {
			for (int j = 1; j < M[0].length; j++) {
				if (j >= capacity[i - 1]) {
					M[i][j] = Math.max(M[i - 1][j], value[i - 1]
							+ M[i - 1][j - capacity[i - 1]]);
				} else {
					M[i][j] = M[i - 1][j];
				}
			}

		}
		System.out.println(M[M.length - 1][maxAllowedCapacity]);

		for (int i = 0; i < M.length; i++) 
		{
			for (int j = 0; j < M[0].length; j++)
			{
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}

		int i = M.length - 1, j = M[0].length - 1;
		while (i > 0 && j > 0)
		{
			if(M[i][j]>M[i-1][j])
			{
				System.out.println("INDEX " + (i-1) + " " + capacity[i-1]);
				j=j-capacity[i-1];

			}
			i=i-1;
		}

	}

}
