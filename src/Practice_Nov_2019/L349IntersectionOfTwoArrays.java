package Practice_Nov_2019;

import java.util.*;

class L349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs1= new HashSet();
        Set<Integer> hs2= new HashSet();

        
        for(int i=0;i<nums1.length;i++)
        {
            hs1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++)
        {
            hs2.add(nums2[i]);            
        }
        List<Integer> res = new ArrayList();      


        Iterator it = hs1.iterator();
        while(it.hasNext())
        {
            int t = (int) it.next();
            if(hs2.contains(t))
            {
                res.add(t);
            }
        }
        
        int[] ans = new int[res.size()];
        int a =0;
        for(int i: res)
        {
            ans[a]=i;
            a++;
        }
        return ans;
    }
}