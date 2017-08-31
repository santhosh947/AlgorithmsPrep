
public class MoveAllZerosToFront {
	public static void main(String[] args) {
		int[] arr= {1,2,3,0,0,0,4,5};
		moveZeroes_tolast(arr);
		for(int i: arr)
			System.out.print(i + " ");
	}

	public static void moveZeroes_tolast(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	private static void moveZeros(int[] arr) {
		int c=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
				c++;
		}
		int[] temp=new int[c];
		int it=0;
		int ct=0;
		for(int i=0;i<arr.length;i++)
		{
			if(ct>c-1)
				ct=0;
			
			if( it<c && arr[i]!=0)
			{
				temp[it]=arr[i];
				it++;
				arr[i]=0;
			}
			else{
				int t=arr[i];
				arr[i]=temp[ct];
				temp[ct]=t;
				ct++;
			}
		}
		
	}
}
