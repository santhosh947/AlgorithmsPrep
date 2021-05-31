package Prc_2020_Q4.Uber;

public class TrianglesInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 5, 5, 4 };
        int[] res = triangles(arr);

        for (int i : res) {
            System.out.println(i);
        }
             
        String s1 = "abcd";
        String s2 = "efghi";

        System.out.println(merge(s1, s2));
    }

    public static String merge(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        // String t_str1 = str1.length() >= str2.length() ? str1 : str2;
        // String t_str2 = str1.length() < str2.length() ? str1 : str2;
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            res.append(str1.charAt(i++));
            res.append(str2.charAt(j++));
        }

        if (i < str1.length()) {
            res.append(str1.substring(i, str1.length()));
        }

        if (j < str2.length()) {
            res.append(str2.substring(j, str2.length()));
        }

        return res.toString();
    }

    public static int[] triangles(int[] arr) {
        int[] res = new int[arr.length - 2];

        for (int i = 0; i < arr.length - 2; i++) {
            if (isTraingle(arr[i], arr[i + 1], arr[i + 2])) {
                res[i] = 1;
            }
        }

        return res;
    }

    public static boolean isTraingle(int a, int b, int c) {
        return ((a + b) > c && (b + c) > a && (a + c) > b) ? true : false;
    }
}
