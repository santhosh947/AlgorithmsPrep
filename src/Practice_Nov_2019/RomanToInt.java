package Practice_Nov_2019;

import java.util.*;

public class RomanToInt 
{
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt_old(String s) {
        int res = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        hm.put('Z',0);

        char prev = 'Z';
        int prev_val = 0;
        for(int i=0;i<s.length();i++)
        {
            if(hm.get(s.charAt(i))<= hm.get(prev))
            {
                res+=hm.get(s.charAt(i));
            }
            else
            {
                res = res + hm.get(s.charAt(i)) - 2*prev_val;
            }
            prev = s.charAt(i);
            prev_val = hm.get(prev);
        }
        return res;
    }

    public static int romanToInt(String s) {
        int res = 0;
        char prev = 'Z';
        int prev_val = 0;
        for(int i=0;i<s.length();i++)
        {
            if(helper(s.charAt(i))<= helper(prev))
            {
                res+=helper(s.charAt(i));
            }
            else
            {
                res = res + helper(s.charAt(i)) - 2*prev_val;
            }
            prev = s.charAt(i);
            prev_val = helper(prev);
        }
        return res;
    }


    public static int romanToInt_optimal(String s) {
        int res = 0;
        
        char c = s.charAt(s.length()-1);
        
        res=helper(c);
        int cur = res;
        
        for(int i = s.length()-2;i>=0;i--){
            int val = helper(s.charAt(i));
            if(val<cur){
                res = res-val;
            }
            else{
                res=res+val;
                cur = val;
            }
        }
        
        return res;
    }
    
    
    private static int helper(char c){
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        if(c=='Z') return 0;
        else return 1000;
    }
}