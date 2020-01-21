package Practice_Nov_2019.DP;

import java.util.*;

import Prac2.ArrayListEx;
import prac.merge;

class Prac_ProrityQueue {
    public static void main(String[] args) {

        List<String> dict = new ArrayList();
        dict.add("leet");
        dict.add("code");
        // System.out.println(wordBreak("leetcode", dict));

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
      //  merge(nums1, 3, nums2, 3);

        int[] nums3 = {};
        int[] nums4 = {1};
        
        merge(nums3, 0, nums4, 1);


        for (int n : nums4) {
            System.out.println(n);
        }

        /**
         * PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
         * 
         * pq.add(3); pq.add(4); pq.add(5); pq.add(3); pq.add(2); pq.add(6); pq.add(2);
         * pq.add(2); pq.add(1);
         * 
         * int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
         * 
         * int r= matrix.length; int c = matrix[0].length;
         * 
         * // for(int i=0;i<r;i++) // { // for(int j=0;j<c;j++) // { //
         * pq.add(matrix[i][j]);
         * 
         * // } // }
         * 
         * Iterator it = pq.iterator();
         * 
         * while(it.hasNext()) { System.out.println(pq.poll()); }
         */
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n>m)
        {
           merge(nums2, n, nums1, m);
           return;
        }
        int t_1 = m+n-1;
        int j= n-1;
        int i=m-1;
        while(i>-1 && j>-1)
        {
            nums1[t_1--] = (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while(j>-1)
        {
            nums1[t_1--]=nums2[j--];
        }
        
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}