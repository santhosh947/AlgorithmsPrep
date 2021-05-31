package Prc_2020_Q4;

public class L852PeakIndexinaMountainArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int idx = 0;
        int mid = 0 + arr.length / 2;
        return Traverse(arr, 0, mid, arr.length - 1);
        // return idx;
    }

    public static int Traverse(int[] arr, int strt, int mid, int end) {
        if (strt < end) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[strt] && arr[mid] > arr[mid - 1]) {
                return Traverse(arr, mid, ((mid + end) / 2), end);
            } else {
                return Traverse(arr, strt, ((strt + mid) / 2), mid);
            }
        }
        return 0;
    }

}
