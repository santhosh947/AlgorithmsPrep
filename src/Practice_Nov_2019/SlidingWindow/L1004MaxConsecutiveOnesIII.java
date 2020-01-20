package Practice_Nov_2019.SlidingWindow;

class L1004MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] A = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        //int[] B = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int[] B = { 1, 1, 1, 0, 0, 0, 0 };

        int[] C = { 0, 0, 0, 1 };

        // System.out.println(longestOnes(A, 3));
         System.out.println(longestOnes(B,0));
       // System.out.println(longestOnes(C, 4));
    }

    public static int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; right++) {
            // If we included a zero in the window we reduce the value of K.
            // Since K is the maximum zeros allowed in a window.
            if (A[right] == 0)
                K--;
            // A negative K denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window
            // size same.
            if (K < 0) {
                // If the left element to be thrown out is zero we increase K.
                if (A[left] == 0)
                    K++;
                left++;
            }
        }
        return right - left;
    }

    public static int longestOnes_self(int[] A, int K) {
        int[] sum1 = new int[A.length];
        int s = 0;
        if (K > A.length)
            return A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1)
                s++;
            sum1[i] = s;
        }

        int i = 0;
        ;
        int t_k = 0;
        int len = 0;
        int c1 = 0;

        for (int j = 0; j < A.length; j++) {
            if (A[j] == 1) {
                c1++;
            } else {
                t_k++;
                if (t_k > K) {
                    len = Math.max(len, j - i);
                    while (i < A.length && A[i] == 1) {
                        i++;
                    }
                    if (A[i] == 0) {
                        c1 = c1 - sum1[i];
                        i = j - c1 - K + 1;
                        t_k--;
                    }
                }
            }
        }
        return len;
    }
}