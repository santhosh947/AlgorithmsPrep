package Prc_2020_Q4;

import java.util.*;

import javax.sql.rowset.spi.XmlReader;

public class L1089DuplicateZeros {

    public static void main(String[] args) {
        System.out.println("hi");

        int[] in1 = { 8, 4, 5, 0, 0, 0, 0, 7 };
        int[] in2 = { 1, 2, 3 };

        duplicateZeros_sol(in1);
        for (int var : in1) {
            System.out.print(var + ",");
        }
    }

    public static void duplicateZeros_sol(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                countZero++;
        }
        int len = arr.length + countZero;
        // We just need O(1) space if we scan from back
        // i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length)
                    arr[j] = arr[i];
            } else {
                if (j < arr.length)
                    arr[j] = arr[i];
                j--;
                if (j < arr.length)
                    arr[j] = arr[i]; // copy twice when hit '0'
            }
        }
    }

    public static void duplicateZeros_optimal(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int zero_cnt = 0;
        int non_zero_cnt = 0;

        int cnt = 0;
        int i = 0;
        for (; i < arr.length; i++) {

            cnt++;
            if (arr[i] == 0) {
                zero_cnt++;
                cnt++;
            } else {
                non_zero_cnt++;
            }

            if (cnt >= arr.length)
                break;
        }
        // int y_boundary = (arr.length % 2 == 0) ? i - 1 : i;
        int y_boundary = i;
        if (non_zero_cnt + zero_cnt * 2 > arr.length) {

        }
        int j = arr.length - 1;

        for (; j >= 0 && y_boundary < arr.length; j--) {
            if (arr[y_boundary] == 0) {
                arr[j] = 0;
                j--;
                arr[j] = 0;
            } else {
                arr[j] = arr[y_boundary];
            }
            y_boundary--;
        }
    }

    public static void duplicateZeros(int[] arr) {
        Queue<Integer> qu = new LinkedList<Integer>();

        if (arr == null || arr.length < 2)
            return;

        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            if (qu.size() > 0 && elem == 0) {
                qu.offer(0);
                qu.offer(arr[i]);
                arr[i] = qu.poll();
            } else if (elem == 0) {
                qu.offer(0);
            } else if (qu.size() > 0) {
                qu.offer(arr[i]);
                arr[i] = qu.poll();
            } else {
                continue;
            }
        }
    }

}
