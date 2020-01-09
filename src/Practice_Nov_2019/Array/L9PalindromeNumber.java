package Practice_Nov_2019.Array;

import java.util.*;

class L9PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(121%10);
        System.out.println(9/10);
        System.out.println(9%10);

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome_op(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;

        int revert =0;
        while(x>revert)
        {
            revert = revert*10 + x%10;
            x/=10;
        }

        return x==revert || x==revert/10;
        
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        List<Integer> a = new ArrayList();

        int t= x;
        while(t>0)
        {
            a.add(t%10);
            t=t/10;
        }

        int i=0;
        int j=a.size()-1;

        while(i<j)
        {
            if(a.get(i)!=a.get(j))
                return false;
            
            i++;
            j--;
        }       

        return true;
        
    }
}