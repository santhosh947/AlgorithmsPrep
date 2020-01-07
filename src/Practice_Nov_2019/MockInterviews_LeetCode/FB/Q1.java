package Practice_Nov_2019.MockInterviews_LeetCode.FB;

import java.util.HashMap;

class Q1 {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));

        //System.out.println(isRepeating("166667"));
        // System.out.println(isRepeating("6666"));
        // System.out.println(isRepeating("012012012"));

        System.out.println(fractionToDecimal(1, 6));

        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));

    }

    public static String fractionToDecimal(int num, int den) {
        
        if(num==0) 
            return "0";
    
        StringBuilder res = new StringBuilder();
    
        // Negative sign is appended if either of num or den is negative
        res.append((num > 0) ^ (den > 0) ? "-" : "");
    
        // Get rid of signs and convert to long to prevent overflow
        long n = Math.abs((long) num);
        long d = Math.abs((long) den);
    
        // Append the integral part
        res.append(n/d);
    
        n %= d;
        if(n==0) 
            return res.toString();             // Cause there is no fraction
    
        // Append the fraction
        res.append(".");
        HashMap<Long, Integer> hm = new HashMap();  // Map will store remainders and their positions
        hm.put(n, res.length());
        while(n!=0) {                               // We will break in case of recurring fraction
            n *= 10;
            res.append(n/d);
            n %= d;
    
            Integer remainderIndex = hm.get(n);
            if(remainderIndex!=null) {              // We have a recurrence
                res.insert(remainderIndex, "(");
                res.append(")");
                return res.toString();
            } else {
                hm.put(n, res.length());            // Add for future checks
            }
        }
        return res.toString();
    }


    public static String fractionToDecimal2(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();

        float div = (float) numerator / (float) denominator;
        int d = numerator / denominator;

        String non_dec = String.valueOf(d);
        String r = String.valueOf(div);

        String frac = r.split("\\.")[1];
        String rep = isRepeating(frac);

        res.append(non_dec);
        if (rep != null) {
            String ss = "(" + rep + ")";
            frac = ss;
            res.append(".");
            res.append(frac);
        } else {
            int v = Integer.parseInt(frac);
            if (v > 0) {
                res.append(".");
                res.append(frac);
            }
        }

        return res.toString();
    }

    public static String isRepeating2(String s) {
        StringBuilder res = new StringBuilder();
//int len = 1;
        int[] pl = new int[10];
        for(int i=0;i< s.length();i++)
        {
            int p = (int)s.charAt(i);
            pl[p]++;
        }

        return res.length() == 0 ? null : res.toString();
    }

    public static String isRepeating(String s) {
        StringBuilder res = new StringBuilder();
        int len = 1;
        
        for (int a = 0; a < s.length(); a++) {
            String ss = s.substring(0, a);
            res = new StringBuilder();
            res.append(ss);
            len = 1;
            boolean found = false;


            for (int i = a; i < s.length() || found; i++) {
                for (int j = 0; j < s.length() - 2 * len; j++) {
                    String prev = s.substring(a, a+len);
                    int st = a+len;
                    int end = a+ 2 * len;
                    String curr = s.substring(st, end);
                    if (prev.equals(curr)) {
                        String str = "(" + prev + ")";
                        res.append(str).toString();
                        found=true;
                        break;
                    } else
                        break;
                }
                len++;
            }
        }

        return res.length() == 0 ? null : res.toString();
    }

    public static String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        StringBuilder suffix = new StringBuilder("maa");
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            String st = "";
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                    || c == 'U') {
                st = words[i];
            } else {
                st = words[i].substring(1, words[i].length()) + words[i].charAt(0);
            }
            st = st + suffix.toString();
            res.append(st);
            if (i < words.length - 1) {
                res.append(" ");
                suffix.append("a");
            }

        }

        return res.toString();
    }

}