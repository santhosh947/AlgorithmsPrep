package prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");		
        //System.out.println(wordBreak("leetcode", dict));
        

        Set<String> dict2 = new HashSet<String>();
		dict2.add("cats");
        dict2.add("dog");	
        dict2.add("sand");
        dict2.add("and");
        dict2.add("cat");
        System.out.println(wordBreak("catsandog", dict2));
	
	}
public static boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
