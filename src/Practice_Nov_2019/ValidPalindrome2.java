package Practice_Nov_2019;

import javax.lang.model.util.ElementScanner6;

public class ValidPalindrome2
{
    public static void main(String[] args) {
       // System.out.println(validPalindrome("aba"));
       // System.out.println(validPalindrome("abbdca"));
        System.out.println(validPalindrome_Optimal("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome_Optimal(String s) {
        if (s.length() < 2) 
            return true;
        return isValid(s.toCharArray(), 0, s.length() - 1, 0);
    }
    
    private static boolean isValid(char[] s, int start, int end, int error) {
        if (start > end)
            return true;
        
        while (start < s.length && end >= 0 && s[start] == s[end]) {
            start++;
            end--;
        }
        
        if (error <= 1) {
            error++;
            return isValid(s, start + 1, end, error) || isValid(s, start, end - 1, error);
        } else {
            return false;
        }
    }
    public static boolean validPalindrome(String str) {
        if(str.length() > 1)
        {
            int s=0, e = str.length() -1;
            int change = 0;
            while(s<e)
            {
                if(str.charAt(s) != str.charAt(e))
                {
                   return isPalin(str, s+1, e)  || isPalin(str, s, e-1);
                }
                else
                {
                    s++; 
                    e--;
                }
            }
        }
        return true;
    }

    public static boolean isPalin(String str, int s, int e)
    {
        while(s<e)
        {
            if(str.charAt(s) != str.charAt(e))
                return false;
            
            s++;
            e--;
        }
        return true;
    }
}