package Prac2;

public class minInSortedArray {
	public static void main(String[] args)
	{
		int[] arr = {1,2};
		System.out.println(findMin(arr));
		/*for(int i =0;i <arr.length;i++)
		{
			System.out.println(arr[i]);
		}*/
	}

	private static int findMin(int[] arr) {
		
		int len = arr.length;
		if(len==0)
			return -1;
		
		if(len == 1)
			return arr[0];	
		
		return findrecurrMin(arr, 0, len);
			
		
	}

	private static int findrecurrMin(int[] arr, int i, int len) {
		
		int mid = (i+len)/2;
		//int rv = mid+1<len ? arr[mid+1] : ;
		//if((arr[mid]< arr[mid+1] && arr[mid] < arr[mid-1]) || i==len)
		if(i==len || (arr[mid]< arr[mid+1] && arr[mid] < arr[mid-1]))
			return mid;
		
		if(mid+1<len && mid-1>=i && arr[mid+1]<arr[i]) 
			return findrecurrMin(arr, mid+1, len);
		
		if(mid+1<len && mid-1>=i && arr[mid+1]>arr[i]) 
			return findrecurrMin(arr, i, mid);
		
		if(mid-1>=i && arr[mid-1]<arr[mid])
			return findrecurrMin(arr, mid-1, mid-1);
		
		if(mid-1>=i && arr[mid-1]>arr[mid])
			return findrecurrMin(arr, mid, mid);
		
		if(mid+1<=len && arr[mid+1]<arr[mid])
			return findrecurrMin(arr, mid+1, mid+1);
		
		if(mid+1<=len && arr[mid+1]>arr[mid])
			return findrecurrMin(arr, mid, mid);
		
		return -1;
		
	}
}
