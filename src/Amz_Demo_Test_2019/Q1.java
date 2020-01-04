package Amz_Demo_Test_2019;

import java.util.*;

class Q1 {
    public static void main(String[] args) {
        // int[] st = { 1, 0, 0, 0, 0, 1, 0, 0 };
        // int[] st2 = { 1, 1, 1, 0, 1, 1, 1, 1 };

        // List<Integer> r = cellCompete(st, 1);

        // for (int t : r) {
        //     System.out.print(t + ",");
        // }

        // List<Integer> r2 = cellCompete(st2, 2);

        // System.out.println();

        // for (int t : r2) {
        //     System.out.print(t + ",");
        // }

        int[] a = {10,8,6,4,2};
        System.out.println(generalizedGCD(5,a));

    }

    public static List<Integer> cellCompete(int[] states, int days) {
        int[] res = new int[states.length];
        for (int k = 0; k < states.length; k++) {
            res[k] = states[k];
        }

        for (int i = 0; i < days; i++) {
          
            for (int j = 0; j < states.length - 1; j++) {
                if (j == 0) {
                    res[j] = states[1] == 0 ? 0 : 1;
                } else {
                    res[j]= states[j - 1] == states[j + 1] ? 0 : 1;
                }
            }
            res[states.length-1] = states[states.length - 2] == 0 ? 0 : 1;

            for (int k = 0; k < res.length; k++) {
                states[k] = res[k];
            }
        }

        List<Integer> ans = new ArrayList();
        for (int k = 0; k < res.length; k++) {
            ans.add(states[k]);
        }
        return ans;
    }

    public static int generalizedGCD(int num, int[] arr)
    {
        int res = arr[0];
        for(int j=1;j<num;j++)
        {
            if(arr[j]>res)
                res = gcd(arr[j],res);
            else
                res = gcd(res,arr[j]);
            if(res==1)
                return 1;
        }

        return res;
    }

    public static int gcd(int a, int b)
    {
        if(a==0)
            return b;
        
        if(a==1)
            return 1;
        
        if(a>b)
            return gcd(a%b,b);
        else
            return gcd(b%a,a);
    }
}