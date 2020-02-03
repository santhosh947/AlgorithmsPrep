package Practice_Nov_2019.Array;

class L33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] n1 = {6,7,1,2,3,4,5};
        int[] n2 = {4,5,6,7,0,1,2};
        int[] n3 = {5,1,2,3,4};
        System.out.println(search2(n3,1));
        System.out.println(search(n3,4));

        System.out.println(search(n2,0));
        System.out.println(search(n2,1));

        System.out.println(search(n1,6));

    }

    public static int search2(int[] nums, int target) {
        if(nums.length==0)
			return -1;
		
        int s=0;
        int e=nums.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[s]<=nums[mid])
            {
                if(target < nums[mid] && target>=nums[s])
                    e=mid-1;
                else
                    s=mid+1;
            }
            if(nums[mid]<=nums[e])
            {
                if(target>nums[mid] && target<=nums[e])
                    s=mid+1;
                else
                    e=mid-1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        
        if(nums==null || nums.length==0)
            return -1;
        return binarySearch(nums,0,nums.length-1,target);
    }

    private static int binarySearch(int[] nums, int l, int r, int t)
    {
        if(l<0 || l>=nums.length || r<0 || r>=nums.length || l>r)
            return -1;
        int mid = l+(r-l)/2;
        if(nums[mid]==t)
            return mid;

        if(mid-1>=l) {
            if((nums[mid-1]<nums[l] && (nums[l]<= t || nums[mid-1]>=t) )|| (nums[mid-1]>=t && nums[l]<=t))
               return binarySearch(nums, l, mid-1, t);
        }
        
        return binarySearch(nums, mid+1, r, t);
        
    }
}