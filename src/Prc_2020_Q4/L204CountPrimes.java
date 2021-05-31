package Prc_2020_Q4;

public class L204CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        // System.out.println(countPrimes(50000000));
        // System.out.println(countPrimes(0));
        // System.out.println(countPrimes(1));

    }

    public static int countPrimes(int n) {
        int[] counter = new int[n];
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (counter[i - 1] == 0) {
                if (isPrime(i)) {
                    fillCt(counter, i);
                    num++;
                }
            }
        }

        return num;
    }

    public static void fillCt(int[] ct, int v) {
        int multiple = v;
        for (int i = 2; i < ct.length && multiple < ct.length + 1; i++) {
            ct[multiple - 1] = 1;
            multiple = v * i;

        }
        return;
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
