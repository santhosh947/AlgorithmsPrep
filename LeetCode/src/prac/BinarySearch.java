package prac;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {3,4,5,6,1,2};
		int[] inp={1,2,3,4,5,6};

		
		/*System.out.println(BinarySearch(inp,0,5,-1));
		System.out.println(BinarySearch2(inp,0,5,-1));
		*/
		
		int pv= pvfindPivot(arr,0,5);
		//System.out.println(pv);
		int find=6;
		
		if(pv>0 && arr[0]<=find)
			System.out.println(BinarySearch(arr, 0, pv, find));
		else if(pv<arr.length-1 && arr[pv+1]<=find)
			System.out.println(BinarySearch(arr, pv+1, arr.length, find));
			
			

	}
	

	private static int pvfindPivot(int[] arr, int lo, int hi) {
		if(hi-lo==1)
		{
			if(arr[lo]>arr[hi])
				return lo;
		}
		int mid = (lo+hi)/2;
		
		if(arr[lo]>arr[mid])
		{
			return pvfindPivot(arr,lo,mid);
		}
		else if(arr[mid+1]>arr[hi])
		{
			return pvfindPivot(arr,mid+1,hi);
		}
		else{
			return mid;
		}
	}


	private static int BinarySearch2(int[] inp, int lo, int hi, int k) {
		while(hi>=lo)
		{
			int mid = (lo+hi)/2;
			if(inp[mid]==k)
			{
				return mid;
			}
			else if(inp[mid]>k)
			{
				hi=mid-1;
			}
			else
			{
				lo=mid+1;
			}
		}
		
		return -1;
	}


	private static int BinarySearch(int[] inp, int lo, int hi, int k) {

		int mid = (lo+hi)/2;
		if(lo==hi && inp[mid]!=k)
		{
			return -1;
		}
		
		if(inp[mid]==k)
		{
			return mid;
		}
		else if(inp[mid]>k &&mid>0)
		{
			return BinarySearch(inp, lo, mid-1, k);
		}
		else if(inp[mid]<k)
		{
			return BinarySearch(inp, mid+1, hi, k);
		}
		
		return -1;
	}

}
