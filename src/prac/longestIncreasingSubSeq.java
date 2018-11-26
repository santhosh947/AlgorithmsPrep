package prac;

import java.util.ArrayList;
import java.util.Collections;

public class longestIncreasingSubSeq {
	public static void main(String[] args) {
		// int[] inp = {3,10,2,1,20};
		// int[] inp = {50, 3, 10, 7, 40, 80};
		int[] inp = { 10, 22, 9, 33, 21, 50, 41, 60 };

		// System.out.println(findLongstSubSeq(inp));
	//	System.out.println(findLongstSubSeqYouTubeWay(inp));
		
		
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
       // System.out.println("Length of Longest Increasing Subsequence is "+
       //                     LongestIncreasingSubsequenceLength(A, n));
        System.out.println(longestSubsequenceRecursive(A));

	}
	
	public static int lengthOfLIS(int[] nums) {
	    ArrayList<Integer> dp = new ArrayList<>(nums.length);
	    for (int num : nums) {
	        if (dp.size() == 0 || dp.get(dp.size()-1) < num)
	        	{
	        	dp.add(num);
	        	}
	        else {
	            int i = Collections.binarySearch(dp, num);
	            dp.set((i<0) ? -i-1 : i, num);
	        }
	    }
	    return dp.size();
	}
	
	 // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
    
    /**
     * Recursive way of solving LIS
     */
    public static int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }
    
    private static int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }
    
    /*public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int result = lis.longestSubsequenceWithActualSolution(arr);
        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);
        System.out.println(result1);
    }*/


 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }

	private static int findLongstSubSeqYouTubeWay(int[] inp) {
		int[] LIS = new int[inp.length];
		int len = LIS.length;
		for (int i = 0; i < len; i++) {
			LIS[i] = 1;
		}
		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (inp[j] > inp[i]) {
					LIS[j] = Math.max(LIS[j], LIS[i] + 1);
				}
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(LIS[i] + "    ");
		}
		System.out.println("******");
		int max = LIS[len - 1];

		int j = len - 1;
		while (j >= 0) {
			if (max == LIS[j]) {
				System.out.println(inp[j]);
				max--;
			}
			j--;			
		}

		return LIS[len - 1];
	}

	private static int findLongstSubSeq(int[] inp) {
		int len = inp.length;
		int[][] arr = new int[len + 1][len + 1];
		for (int i = 1; i < len + 1; i++) {
			int prev = inp[i - 1];
			for (int j = i; j < len + 1; j++) {
				if (j == len && arr[i - 1][j] > arr[i][j - 1] + 1) {
					arr[i][j] = arr[i - 1][j];
				} else if (inp[j - 1] > inp[i - 1] && inp[j - 1] > prev) {
					prev = inp[j - 1];
					arr[i][j] = arr[i][j - 1] + 1;
				} else if (i == j) {
					arr[i][j] = 1;
				} else if (i > j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = arr[i][j - 1];
				}
			}
		}

		printElements(arr, inp);
		System.out.println("************");
		return arr[len][len];
	}

	private static void printElements(int[][] arr, int[] inp) {
		int len = arr.length;
		int i = len - 1;
		int j = len - 1;

		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				System.out.print(arr[a][b] + " ");
			}
			System.out.println();
		}
		while (i > 0 && j > 0) {
			if (arr[i][j] == arr[i][j - 1] + 1) {
				// System.out.println("i: " + i + "j: " +j);
				System.out.println(inp[j - 1]);
				j = j - 1;
			}

			else if (arr[i][j] == arr[i - 1][j]) {
				i = i - 1;
			} else {
				j = j - 1;
			}
		}
	}
}
