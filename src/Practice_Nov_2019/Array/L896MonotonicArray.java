package Practice_Nov_2019.Array;


class L896MonotonicArray {
    public static void main(String[] args) {
        int[] A = {1,2,2,3};
        System.out.println(isMonotonic(A));
    }

    public static boolean isMonotonic(int[] A) {
        return BinarySearch(A,0,A.length-1);
    }
    
    private static boolean BinarySearch(int[] A, int s, int e)
    {
        if(s>=e || s<0 || e<0 || s>A.length-1 || e>A.length-1)
            return true;
        
        int mid = s +(e-s)/2;
        
        int left = mid-1>=s? mid-1 : mid;
        int right = mid+1<=e ? mid+1 : mid;
        
        if((A[left]<=A[mid] && A[mid]<=A[right]) ||
           (A[left]>=A[mid] && A[mid]>=A[right]))
        {
            return BinarySearch(A,s,left) && BinarySearch(A,right,e);
        }
        return false;
    }
}