package Practice_Nov_2019;

class L29DivideTwoNumbers {
    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;


        while(a-b>= 0)
        {
            int x =0;
            while(a-(b << 1 << x)>=0)
            {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }

        if((dividend>=0 && divisor>=0) || (dividend<0 && divisor<0))
            return res;
        else
            return (-1*res);

       // return res;
    }
}