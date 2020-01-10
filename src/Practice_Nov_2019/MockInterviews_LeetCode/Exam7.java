package Practice_Nov_2019.MockInterviews_LeetCode;

import java.util.*;

class Exam7 {
    public static void main(String[] args) {
        String[] w = {"cat","bt","hat","tree"};
        String c = "atach";

        System.out.println(countCharacters(w,c));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] pos = new int[26];
        int[] p2 = new int[26];       
        int len=0;
        for(int i=0;i<chars.length();i++)
        {
            char c= chars.charAt(i);
            pos[c-'a']+=1;
            p2[c-'a']+=1;
        }


        for(int i=0;i<words.length;i++)
        {
            for(int k=0;k<p2.length;k++)
            {
                pos[k] = p2[k];
            }
            int j=0;            
            for(j=0;j<words[i].length() && words[i].length()<= (chars.length());j++)
            {
                char c = words[i].charAt(j);
               if(pos[c-'a']>0)
                {                   
                   pos[c-'a']-=1;
                    len++;                
                }
                else {
                    len=len-j;
                    break;                    
                }
            }
        }

        return len;
        
    }


    public static int countCharacters2(String[] words, String chars) {
        //int res =0;
        int[] pos = new int[26];
        int len=0;
        for(int i=0;i<chars.length();i++)
        {
            char c= chars.charAt(i);
            pos[c-'a']+=1;
        }

       // List<String> st = new ArrayList();

        for(int i=0;i<words.length;i++)
        {
            int j=0;
            for(j=0;j<words[i].length() && words[i].length()<= (chars.length()-len);j++)
            {
                char c = words[i].charAt(j);
                if(pos[c-'a']==0)
                {
                    j--;
                    while(j>=0)
                    {
                        c = words[i].charAt(j);
                        pos[c-'a']+=1;
                        len--;
                    }
                    break;
                }
                else {
                    pos[c-'a']-=1;
                    len++;
                }
            }
            // if(j==words[i].length()){
            //     st.add(words[i]);
            // }
        }

        return len;
        
    }
}