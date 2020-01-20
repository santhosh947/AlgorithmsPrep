
package Practice_Nov_2019;

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] argv) {
        
      //  System.out.println(digitsManipulations(123456));//true
       // System.out.println(digitsManipulations(1010));//true

        System.out.println(composeKPalindromes("palindromic",10));//true
        System.out.println(composeKPalindromes("abracadabra",2));//false
        System.out.println(composeKPalindromes("abracadabra",3));//true



      //  System.out.println(isValidNonogram(matrix, rows2, columns2)); // false
    }

    public static boolean composeKPalindromes(String s, int k) {
        Map<Character, Integer> hm = new HashMap();

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);

            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int num_odds=0;
        int num_evens=0;
		int sum_even =0;
		Iterator it = hm.entrySet().iterator();
		while(it.hasNext())
		{
            Map.Entry mapElement = (Map.Entry)it.next(); 
            int val = (int) mapElement.getValue();
            if(val%2==0)
            {
                num_evens++;
                sum_even+=val;
            }
            else
            {
                num_odds++;
            }            
        }
        if(num_odds%k==0)
            return true;
        else 
        {
            while(num_odds<k) {
                num_odds/=k;
            }

            
            int rem = num_odds/k;
            rem = k-rem;
            if(rem>0 && sum_even/rem==0)
                return true;
            return false;
        }
    }

    public static int digitsManipulations(int n) {
        int t= n;
        int product = 1;
        int sum = 0;
        while(t>0)
        {
            int r = t%10;
            product*=r;
            sum+=r;
            t=t/10;
        }

        return product-sum;
    }
}
