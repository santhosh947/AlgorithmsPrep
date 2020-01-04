package Practice_Nov_2019.DP;

class L42TrappingRainWater {
    public static void main(String[] args) {
        int[] ht =  {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(ht));
    }

    public static int trap(int[] height) {
        int res =0;

        if(height.length <3)
            return res;

        int l =0;
        int r = height.length-1;

        while(l<r && height[l]<=height[l+1])
            l++;
        
        while(l<r && height[r] <= height[r-1])
            r--;
        
        
        while(l<r)
        {
            int left = height[l];
            int right = height[r];
            if(left< right)
            {
                while(l<r && left >= height[++l])
                {
                    res+= left-height[l];
                }
            }
            else {
                while(l<r && right >= height[--r])
                {
                    res += right - height[r];
                }
            }
        }
        
        return res;
    }
}