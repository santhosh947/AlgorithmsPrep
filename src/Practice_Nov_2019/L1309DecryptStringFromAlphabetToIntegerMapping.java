package Practice_Nov_2019;

class L1309DecryptStringFromAlphabetToIntegerMapping {
    public static void main(String[] args) {
       // System.out.println('a'+(int));
       System.out.println((char)( 25 +'a'));
       System.out.println((char)('a'+2));
        System.out.println(freqAlphabets("1326#"));
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets("25#"));
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));

        
    }

    public static String freqAlphabets(String s) {
        StringBuilder st = new StringBuilder(s);
        st = st.reverse();
        StringBuilder res = new StringBuilder();
        for(int i=s.length()-1;i>-1;i--)
        {
            if(s.charAt(i)=='#')
            {
                char c = (char)('a'+Integer.parseInt(s.substring(i-2, i))-1);
                res.append(c);
                i=i-2;
            }
            else {
                char c = (char)('a'+ (Integer.parseInt(String.valueOf(s.charAt(i)))-1));
                res.append(c);
            }
        }
        return res.reverse().toString();                
    }

}