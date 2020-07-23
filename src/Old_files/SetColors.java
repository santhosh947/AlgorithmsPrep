package Old_files;

public class SetColors {
	public static void main(String[] args) {
		int[] arr= {0,1,1,2,0,2};
		for(int i:arr)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		sortColors(arr, arr.length);
		for(int i:arr)
		{
			System.out.print(i + " ");
		}
	}
	public static void sortColors(int A[], int n) {
	    int n0 = -1, n1 = -1, n2 = -1;
	    for (int i = 0; i < n; ++i) {
	        if (A[i] == 0) 
	        {
	            A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
	        }
	        else if (A[i] == 1) 
	        {
	            A[++n2] = 2; A[++n1] = 1;
	        }
	        else if (A[i] == 2) 
	        {
	            A[++n2] = 2;
	        }
	    }
	}
}
