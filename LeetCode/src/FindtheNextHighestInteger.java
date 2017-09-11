import java.util.Arrays;

public class FindtheNextHighestInteger {
	// Java program to find next greater
	// number with same set of digits.

	// Utility function to swap two digit
	static void swap(char ar[], int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	// Given a number as a char array number[],
	// this function finds the next greater number.
	// It modifies the same array to store the result
	static void findNext(char ar[], int n) {
		int i;

		// I) Start from the right most digit
		// and find the first digit that is smaller
		// than the digit next to it.
		for (i = n - 1; i > 0; i--) {
			if (ar[i] > ar[i - 1]) {
				break;
			}
		}

		// If no such digit is found, then all
		// digits are in descending order means
		// there cannot be a greater number with
		// same set of digits
		if (i == 0) {
			System.out.println("Not possible");
		} else {
			int x = ar[i - 1], min = i;

			// II) Find the smallest digit on right
			// side of (i-1)'th digit that is greater
			// than number[i-1]
			for (int j = i + 1; j < n; j++) {
				if (ar[j] > x && ar[j] < ar[min]) {
					min = j;
				}
			}

			// III) Swap the above found smallest
			// digit with number[i-1]
			swap(ar, i - 1, min);

			// IV) Sort the digits after (i-1)
			// in ascending order
			Arrays.sort(ar, i, n);
			System.out.print("Next number with same" + " set of digits is ");
			for (i = 0; i < n; i++)
				System.out.print(ar[i]);
		}
	}
	
	static void findNextHighestNum(char[] num)
	{
		if(num==null)
			return;
			
		int len=num.length;
		int min=0;
		int i=0;
		for(i=len-1;i>0;i++)
		{
			if(num[i-1]<num[i])
			{
				min=i;
				break;
			}
		}
		
		
		for(int j=i+1;j<len;j++)
		{
			if(num[i-1]<num[j] && num[min]>num[j])
			{
			   min=j;
			}
		}
		
		
		swap(num,i-1,min);
		Arrays.sort(num,i,len);
		for(char c:num)
		{
		  System.out.print(c);
		}
	}


	public static void main(String[] args) {
		int num=218765;
		String str=String.valueOf(num);
		char digits[] = { '5', '3', '4', '9', '7', '6' };
		digits=str.toCharArray();
		int n = digits.length;
		findNext(digits, n);
		System.out.println();
		findNextHighestNum(digits);

	}

}
