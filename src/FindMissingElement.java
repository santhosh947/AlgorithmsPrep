
public class FindMissingElement {
	public static void main(String[] args) {
		int[] arr = { 15, 16, 18, 19,20};
		System.out.println(findElement(arr,0,arr.length));
		
		
	}

	private static int findElement(int[] arr,int s,int e) {
		if(e-s==1)
			return arr[s]+1;
		int mid = (s+e)/2;
		if(arr[mid]-arr[s]!=mid)
		{
			return findElement(arr,0, mid);
		}
		else
		{
			return findElement(arr, mid, e);
		}
	}
}
