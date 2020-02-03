package Practice_Nov_2019.Array;

class L153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] n2 = {2,1};
        int[] n3 = {4,5,6,7,0,1,2};
        System.out.println(findMin(n2));
        System.out.println(findMin(n3));
    }
    private static int min;
    public static int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        
        min = Integer.MAX_VALUE;
        binarySearch(nums,0,nums.length-1);
        return min;
        
    }

    private static void binarySearch(int[] n, int l, int r)
    {
        if(l<0 || r<0 || l>n.length-1 || r>n.length-1 || l>r)
            return;

        int m = l +(r-l)/2;
        if(n[m]<min)
            min = n[m];

        if(n[m]<n[r])
        {
            binarySearch(n,l,m-1);
        }
        
        binarySearch(n,m+1,r);      
        
        return;
    }
}