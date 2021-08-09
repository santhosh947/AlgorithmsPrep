package Prc_2020_Q4.Uber;

public class CountOccurrences {
    public int countAllOcurrences(int n) {
        int result = 0;

        while (n > 0) {
            int reminder = n % 10;
            System.out.println(" *****   " + reminder);
            switch (reminder) {
                case 0:
                    result++;
                    break;
                case 2:
                    result++;
                    break;
                case 4:
                    result++;
                    break;
                default:
            }
            n = n / 10;
        }
        return result;
    }

    public int numberOfsinRange(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += countAllOcurrences(i);
        }
        return count;
    }

    public int numberOfZero(int n){
        n = Math.abs(n);
        int res = 0;
        while(n>0){
            int rem = n %10;
            if(rem == 0)
            {
                res++;
            }
            n/=10;
        }

        return res;
    }

    public static void main(String[] args) {
        CountOccurrences oc;
        oc = new CountOccurrences();
       // int total = oc.numberOfsinRange(22);
        //System.out.println(total);

        System.out.println(oc.numberOfZero(1000));

    }

    //26 , boolean 0-a, 2 -b, 3-c
    //boolean -> flase;
    //2 ->abc
    //4-> ghi
    

}
