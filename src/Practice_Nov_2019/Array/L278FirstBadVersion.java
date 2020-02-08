package Practice_Nov_2019.Array;

class L278FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }


    public static int firstBadVersion(int n) {
        return BinarySearch(1,n);
    }
    
    private static boolean isBadVersion(int n)
    {
        return n>=4;
    }
    private static int BinarySearch(int st, int end)
    {
        if(st>=end || st<0 || end<0)
            return st;
        
        int mid = st + (end-st)/2;
        
        if(!isBadVersion(mid))
        {
           return BinarySearch(mid+1, end);
        }
        else if(!isBadVersion(mid-1)){
            return mid;
        }
        else {
          return  BinarySearch(st,mid-1);
        }
       // return mid;
    }
}