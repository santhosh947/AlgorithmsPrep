package Practice_Nov_2019;

import java.util.*;


class SingleNumber {
    public static void main(String[] args) {
        int[] n = {4,1,2,1,2};
       // System.out.println(singleNumber(n));

        System.out.println(isHappy(2));

    }

    public static boolean isHappy(int n) {
        Set<Integer> hs = new HashSet();
        while(n!=1) 
        {
            System.out.println(n);       

            if(hs.contains(n))
                return false;
            
            hs.add(n);
            int res = 0;
            int t = n;
            while(t>0)
            {
                int rem = t%10;
                res+=rem*rem;
                t/=10;
            }
            n=res;

        }
        return true;
    }
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(i%2==0)
            {
                res+=nums[i];
            }
            else
            {
               res-=nums[i]; 
            }            
        }
        
        return res;
    }
}