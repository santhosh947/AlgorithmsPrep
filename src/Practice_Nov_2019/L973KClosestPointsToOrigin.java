package Practice_Nov_2019;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class L973KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] p = { { 1, 3 }, { -2, 2 } };
        int[][] res = kClosest(p, 1);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }

    //public static int[][] points;

    public static int[][] kClosest(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K)
                break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private static int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0)
                r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0)
                l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private static int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}