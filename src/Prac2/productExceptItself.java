package Prac2;

public class productExceptItself {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] res = productExceptItself(nums);
		
		for(int i:res)
		{
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static int[] productExceptItself(int[] nums) {
		int[] res= new int[nums.length];
		int fwdMult =1;
		int backMult =1;
		res[0]=1;
		for(int i=1;i<nums.length;i++)
		{
			fwdMult = fwdMult * nums[i-1];
			res[i]=fwdMult;
		}
		for(int j=nums.length-1;j>=0;j--)
		{
			res[j]=res[j]*backMult;
			backMult = backMult * nums[j];
		}
		return res;
	}
}
