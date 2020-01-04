


class L374GuessGame {
    public static void main(String[] args) {
        System.out.println(guessNumber2(2126753390));
        System.out.println(guessNumber(2126753390));

    }

    public static int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int guessNumber(int n) {
        return pick(1,n);
    }
    
    public static int pick(int l, int r)
    {
        int t = l+(r-l)/2;
        //int t = (int)tl;
        int num = guess(t);
        if(num==0)
            return t;
        else if(num==-1)
            return pick(l,t-1);
        else
            return pick(t+1,r);
        
    }

    private static int guess(long t) {
        if(t==1702766719)
            return 0;
        else if(t>1702766719)
            return -1;
        else 
           return 1;
    }
}