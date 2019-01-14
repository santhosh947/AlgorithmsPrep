package Prac2;

public class onePlus {
	public static void main(String[] args) {
		int[] in1 = { 1, 2, 3 };
		int[] in2 = { 9 };

		//int[] r1 = plusOne(in1);
		int[] r2 = plusOne(in2);

		/*for (int i : r1) {
			System.out.print(i + ",");
		}*/
		
		System.out.println();
		
		for (int i : r2) {
			System.out.print(i + ",");
		}
	}

	public static int[] plusOne(int[] digits) {
		int carry = 0;
		for(int i=digits.length-1;i>=0;i--)
		{
			if(digits[i]==9)
			{
				digits[i]=0;
				carry=1;
				i--;
				while(carry==1 && i>=0)
				{
					if(digits[i]==9)
					{
						digits[i]=0;
						carry=1;
					}
					else
					{
						digits[i]=digits[i]+carry;
						carry=0;
					}
					i--;
				}
				break;
			}
			else
			{
				digits[i]=digits[i]+1+carry;
				break;
			}
		}
		int[] res = new int[digits.length+1];
		if(carry==1)
		{
			res[0]=1;
			for(int i=0;i<digits.length;i++)
			{
				res[i+1]=digits[i];
			}
			return res;
		}
		return digits;
	}
}
