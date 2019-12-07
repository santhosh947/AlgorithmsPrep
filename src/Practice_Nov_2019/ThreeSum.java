package Practice_Nov_2019;

import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class ThreeSum
{
    public static void main(String[] args) {
        int[] in = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(in);
        System.out.println();
        for(int i=0;i<res.size();i++)
        {
            List<Integer> inRes = res.get(i);
            for(int j=0;j<inRes.size();j++)
            {
                System.out.print(inRes.get(j)+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] num)
    {
        Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) 
                    {
                        lo++;
                    }
                    while (lo < hi && num[hi] == num[hi-1])
                    {
                         hi--;
                    }
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) 
                {
                    lo++;
                }
                else 
                {
                    hi--;
                }
           }
        }
    }
    return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Set<List<Integer>> set1 = new HashSet<>();

        if(nums.length<3)
            return res;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++)
        {
           // if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {

            int a = nums[i];
            int j = nums.length-1;
            int z = i+1;

            int sum = 0 - a;
            int b = nums[j];
            int c = nums[z];
            while(z<j)
            {
                if(b+c== sum)
                {
                    List list = Arrays.asList(a,b,c);

                    if(!set1.contains(list))
                    {
                        res.add(list);
                        set1.add(list);
                    }
                    z++;
                    b=nums[j];
                    c=nums[z];
                }
                else if(b+c < sum)
                {
                    j--;
                    b=nums[j];

                }
                else {
                    z++;
                    c=nums[z];

                }
            }
       // }      

        }

        return res;
    }

    public static List<List<Integer>> threeSum_non_optimal(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        if(nums.length<3)
            return res;

        Map<Integer, HashSet<Integer>> st = new HashMap<Integer, HashSet<Integer>>();
        
        for(int i=0; i < nums.length-2;i++)
        {
            int a, b, c;
            a = nums[i];
            int j=i+1;
            int z =0;
            while(j<nums.length-1)
            {
                z=j+1;
                b=nums[j];
                if(!(st.containsKey(a) ? st.get(a).contains(b) : false))
                {
                    while(z<nums.length)
                    {
                        c=nums[z];
                        if(a+b+c==0)
                        {
                            HashSet<Integer> hs = (HashSet<Integer>) (st.containsKey(a) ? st.get(a) : new HashSet<>());
                            hs.add(b);
                            hs.add(c);
                            st.put(a,hs);


                            hs = (HashSet<Integer>) (st.containsKey(b) ? st.get(b) : new HashSet<>());
                            hs.add(a);
                            hs.add(c);
                            st.put(b,hs);

                            
                            hs = (HashSet<Integer>) (st.containsKey(c) ? st.get(c) : new HashSet<>());
                            hs.add(a);
                            hs.add(b);
                            st.put(c,hs);

                            res.add(Arrays.asList(a,b,c));

                            break;
                        }
                        z++;
                    }
                }
                j++;
           }
        }
        return res;
    }
}