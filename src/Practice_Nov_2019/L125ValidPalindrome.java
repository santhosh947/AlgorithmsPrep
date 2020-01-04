package Practice_Nov_2019;

class L125ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }

    public static boolean isPalindrome(String s) {
        if(s==null || s.length() == 0 || s.length() == 1)
            return true;
        
        //s=s.replaceAll("\\s+","");
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        
        while(i<j)
        {
            while(i<s.length()-1 && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            
            while(j>-1 && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            
            
            if(i<j && s.charAt(j--)!=s.charAt(i++))
                return false;
        }
        return true;
    }
}