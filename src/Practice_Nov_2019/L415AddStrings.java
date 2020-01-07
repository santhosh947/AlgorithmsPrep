package Practice_Nov_2019;

class L415AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
        
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder res= new StringBuilder();
        int n = num1.length()-1;
        int m = num2.length()-1;

        if(n<m)
            return addStrings(num2,num1);

        int carry =0;
        while(n>-1 || m>-1)
        {
            int c = Character.getNumericValue(num1.charAt(n--));
            int d = m > -1 ? Character.getNumericValue(num2.charAt(m--)) : 0;
            
            int s = c+d+carry;

            carry = s/10;
            res.append(s%10);           

        }
        if(carry==1)
            res.append(1);

        return res.reverse().toString();
    }
}