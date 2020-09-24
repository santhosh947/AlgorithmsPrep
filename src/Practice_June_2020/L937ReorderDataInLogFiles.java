package Practice_June_2020;

import java.util.*;

public class L937ReorderDataInLogFiles {
    public static void main(String[] args) {
        System.out.println("hi");
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        String[] res = reorderLogFiles(logs);

        if(res!=null)
        {
            for(int i=0;i<res.length;i++)
            {
                System.out.println(res[i]);
            }
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        ArrayList<String> withDigits = new ArrayList();
        int k = 0;
        for(int i=0;i<logs.length;i++)
        {
            String str = logs[i];
            String sec_wrd = str.split(" ")[1];
            if(sec_wrd.length()<2)
            {
                withDigits.add(str);
            }
            else{
                res[k]=str;
                k++;
            }
        }

        

        return null;
        
    }
}