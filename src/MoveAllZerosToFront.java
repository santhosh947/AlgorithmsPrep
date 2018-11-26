import java.util.ArrayList;
import java.util.List;

public class MoveAllZerosToFront {
	public static void main(String[] args) {
		int[] arr= {0,2,0,0,0,0,0,4,5};
		moveZeros_Front(arr);
		for(int i: arr)
			System.out.print(i + " ");
	}
	
	public static void moveZeros_Front(int[] nums)
	{
		if(nums==null || nums.length ==0)
			return;
		
		int c=0, len=0;
		List<Integer> pos=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0)
			{
				len++;
				c++;
				pos.add(i);
			}
			
		}
		
		for(int i: pos)
		{
			if(i<c)
			{
				c--;
			}
		}
		
		int[] temp=new int[c];
		int ct=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=0 && ct<c)
				temp[ct++]=nums[i];
		}
		
		for(int i=0;i<len;i++)
		{
			nums[i]=0;
		}
		
		ct=0;
		for(int i=len;i<len+c;i++)
		{
			nums[i]=temp[ct++];
		}
		
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
	
}
