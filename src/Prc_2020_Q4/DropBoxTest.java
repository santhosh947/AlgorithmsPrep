package Prc_2020_Q4;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class DropBoxTest {
    public static void main(String[] args) {
        String[] str = {"12", "21"};
        String[] res = say_what_you_see(str);

        for(String s:res){
            System.out.println(s);
        }
    }


public static String[] say_what_you_see(String[] input_strings) {
        String[] res = new String[input_strings.length];
        int idx = 0;
        //12
        for(String s: input_strings){
            StringBuilder format = new StringBuilder();
            //1,2
            char[] ca = s.toCharArray();
            //1
            char prev = ca[0];
            int count = 1;
            for(int i =1;i<ca.length;i++){
                //2
                char next = ca[i];
                if(prev == next){
                    count++;
                }else{
                    format.append(count);
                    format.append(prev);                    
                    count=1;
                    prev = next;
                }
            }

            format.append(count);
            format.append(prev);

            res[idx++] = format.toString();
        }   

    return res;

}
}
