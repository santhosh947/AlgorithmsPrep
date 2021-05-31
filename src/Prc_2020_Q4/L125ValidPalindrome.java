package Prc_2020_Q4;

public class L125ValidPalindrome {
    public static void main(String[] args) {
        // System.out.println(isPalindrome("race a car"));
        int[] a = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate2(a));
    }

    public static boolean isPalindrome(String s) {
        boolean isPalin = true;

        char[] arr = s.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char a = arr[i];

            while (!Character.isLetterOrDigit(a) && i < j) {
                i++;
                a = arr[i];
            }
            a = Character.toLowerCase(arr[i]);

            char b = arr[j];

            while (!Character.isLetterOrDigit(b) && i < j) {
                j--;
                b = arr[j];
            }
            b = Character.toLowerCase(arr[j]);

            if (i < j && a != b) {
                return false;
            }

        }

        return isPalin;
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        int next = nums[i];

        while (nums[next] >= 0) {
            if (nums[next] == 0) {
                return next;
            }
            i = next;
            int temp = nums[next];
            nums[next] = 0;
            next = temp;

        }

        return -1;
    }

    // without changing the arr values - similar to linked list cycle II
    public static int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
