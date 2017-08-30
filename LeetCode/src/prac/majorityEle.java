package prac;

public class majorityEle {
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,2,2,2,3,3,3,3,2,2,2,3,3};
		
		System.out.println(Math.floor(-4.7));
		System.out.println(Math.round(-4.7));
		System.out.println(Math.ceil(-4.7));
	//	System.out.println(Math.m;
		System.out.println(majorityElement(arr));
		
		int k=9;
		
		Test.doi(6,4,k);
		System.out.println(k);
	}
	

	private static int majorityElement(int[] arr) {
		int major = arr[0], cnt=0;
		for (int i : arr)
		{
			if(cnt==0)
			{
				major=i;
				cnt++;
			}
			else if(i==major)
			{
				cnt++;
			}
			else
			{
				cnt--;
			}
		}
		return major;
	}
	
	public static int majorityElement2(int[] num) {
		int count = 0; int major = num[0];
		for(int i:num) {
			if(count==0){ major=i; count++;	}
			else if(i==major) count++;
			else count--;
		}
		return major;
	}

}
