package Practice_Nov_2019.Array;

import java.util.*;

public class L581ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab",2,3,4));
        System.out.println(maxFreq("aaaa",1,3,3));
        System.out.println(maxFreq("aabcabcab",2,2,3));


        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] A) {
            if(A==null || A.length < 2)
                return 0;
        
            int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
            for (int i=1;i<n;i++) {
              max = Math.max(max, A[i]);
              min = Math.min(min, A[n-1-i]);
              if (A[i] < max) 
                end = i;
              if (A[n-1-i] > min) 
                beg = n-1-i; 
            }
            return end - beg + 1;
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        int n = s.length(), resCnt = 0;
        if(minSize > n) 
            return 0;
        for(int i = 0; i < n; i++){            
            Map<Character, Integer> map = new HashMap<>();
            for(int distNum = 0, j = 0; j < maxSize; j++){
                if(i + j >= n) 
                    break;
                map.put(s.charAt(i + j), map.getOrDefault(s.charAt(i + j), 0) + 1);
                if(map.get(s.charAt(i + j)) == 1) 
                    distNum++;
                if(distNum > maxLetters) 
                    break;
                if(j >= minSize - 1)
                    res.put(s.substring(i, i + j + 1), res.getOrDefault(s.substring(i, i + j + 1), 0) + 1);       
            }
        }
        for(String str: res.keySet()){            
            if(res.get(str) > resCnt)
                resCnt = res.get(str);
        }
        return resCnt;        
    }
}