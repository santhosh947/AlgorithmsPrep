package Practice_Nov_2019.MockInterviews_LeetCode;

class Exam5 {
    public static void main(String[] args) {

        // System.out.println("LEET".indexOf("Code"));
        // System.out.println("ABCABC".indexOf("ABC"));

        // System.out.println("ABC".indexOf("ABCABC"));

        // System.out.println("ABABAB".indexOf("ABAB"));

        System.out.println(gcdOfStrings("ABCABC", "ABC"));

         System.out.println(gcdOfStrings("ABABAB", "ABAB"));
         System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    private static String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (m > n)
            return gcdOfStrings(str2, str1);

        
        if(str1.equals(str2))
            return str1;

        int id = str1.indexOf(str2);
        

        if (id == -1 || id > 0)
            return "";
            
        str1 = str1.substring(id+str2.length(), str1.length());
        return gcdOfStrings(str1,str2);
       
    }

    public static String gcdOfStrings2(String str1, String str2) {
       // String res = "";
        StringBuilder ptn = new StringBuilder();

        return helper(str1, str2, ptn);

        // int n = str1.length();
        // int m = str2.length();
        // if(m>n)
        // return gcdOfStrings(str2, str1);

        // if(str1.indexOf(str2)==-1)
        // return res;
        // else
        // {
        // int i=0, j=0;

        // while(j<m && i< n)
        // {
        // ptn.append(str2.charAt(j));
        // j--;
        // }
        // }

        // System.out.println("LEET".indexOf("Code"));

       // return res;

    }

    private static String helper(String str1, String str2, StringBuilder ptn) {
        int n = str1.length();
        int m = str2.length();
        if (m > n)
            return helper(str2, str1,ptn);

        
        if(str1.equals(str2))
            return str1;

        int id = str1.indexOf(str2);
        

        if (id == -1 || id > 0)
            return "";
       // else {         
            
        str1 = str1.substring(id+str2.length(), str1.length());
        return helper(str1,str2, ptn);
        //return res;    
        //}

        //return ptn.toString();
    }
}