package Practice_Nov_2019.MockInterviews_LeetCode.FB;

class Exam4 {
    public static void main(String[] args) {

      //  System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
      System.out.println(validPalindrome("atbbga"));
         System.out.println(validPalindrome("abc"));
         System.out.println(validPalindrome("aba"));

        System.out.println(validPalindrome("abca"));

        // System.out.println(isPalindrome("a."));

        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        // System.out.println(isPalindrome("race a car"));
    }

    public static boolean validPalindrome(String s)
    {
        boolean l = true;
        if(s.length()>1)
        {
            l = isValid(s,0,s.length()-1,0);
        }
        return l;
    }

    private static boolean isValid(String s, int i, int j, int c) {
        if(i>j)
            return true;
        else if(s.charAt(i)!=s.charAt(j) && c>0)
            return false;
        else if(s.charAt(i)!=s.charAt(j))
            return isValid(s,i+1,j,c+1) || isValid(s,i,j-1,c+1);
        else
        {
           return isValid(s,++i,--j,c);
        }
       // return true;
    }

    public static boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        int deleted = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j) && deleted == 0) 
            {
                if (j > -1 && i < j && s.charAt(i) == s.charAt(j - 1)) 
                {
                    j--;
                    deleted++;
                } 
                else if (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(j))
                {
                    i++;
                    deleted++;
                }
                else 
                {
                return false;
                }
            }
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }   

        return true;

    }

    public static boolean isPalindrome(String s) {

        s = s.replaceAll("\\ ", "");
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (j > -1 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

}