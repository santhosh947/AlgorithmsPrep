package Prc_2020_Q4;

public class L88MergeSortedArray {
    public static void main(String[] args) {
        int[] n1 = { 0 };
        int[] n2 = { 1 };

        for (int i : n1) {
            System.out.print(i + ",");
        }
        System.out.println();
        merge(n1, 0, n2, 1);

        for (int i : n1) {
            System.out.print(i + ",");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { // only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }

    public static void merge_obselete(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int p_i = 0;
        int j = 0;
        int p_j = 0;
        int m_ptr = m;

        int ct = 0;

        for (; ct < m + n;) {

            int v1 = (i < nums1.length && p_i < m) ? nums1[i] : Integer.MAX_VALUE;
            int v2 = (j < nums2.length && p_j < n) ? nums2[j] : nums1[m_ptr - 1];

            if (v1 <= v2) {
                p_i++;
                i++;
                // j++;
            } else {
                int temp = nums1[i];
                nums1[i] = v2;
                if (m_ptr > nums1.length - 1) {
                    nums1[m_ptr - 1] = temp;

                } else {
                    nums1[m_ptr] = temp;
                    m_ptr++;

                }
                // p_j++;
                j++;
                i++;
            }
            // i++;
            ct++;
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int n2 = 0;
        int t_m = m;
        int t_n = n;
        int i = 0;
        for (i = 0; i < nums1.length && n2 < nums2.length;) {
            if (t_m > 0) {
                int v1 = nums1[i];
                int v2 = nums2[n2];

                if (v1 <= v2) {
                    // i++;
                    t_m--;
                } else {
                    nums1[m] = v1;
                    nums1[i] = v2;
                    n2++;
                    m++;
                    t_n--;
                }
            } else {
                nums1[i] = nums2[n2];
                n2++;
                // i++;
            }
            i++;
        }
        while (i < m && i < nums1.length && t_m > 0) {
            if (nums1[i] > nums1[m - 1]) {
                int temp = nums1[i];
                nums1[i] = nums1[m - 1];
                nums1[m - 1] = temp;
            }
            i++;
        }
    }
}
