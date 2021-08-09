package Prc_2020_Q4;
import java.util.*;

public class L17LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        List<String> res = letterCombinations("23");

        for(String str:res){
            System.out.println(str);
        }
        
    }

    static HashMap<Character, Character[]> hm = new HashMap<>();
    static List<String> list=new ArrayList<>();
    static String combination="";
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return list;
        hm.put('2',new Character[]{'a','b','c'});
        hm.put('3',new Character[]{'d','e','f'});
        hm.put('4',new Character[]{'g','h','i'});
        hm.put('5',new Character[]{'j','k','l'});
        hm.put('6',new Character[]{'m','n','o'});
        hm.put('7',new Character[]{'p','q','r','s'});
        hm.put('8',new Character[]{'t','u','v'});
        hm.put('9',new Character[]{'w','x','y','z'});
        combine(digits,0);
        return list;
        
    }
    private static void combine(String digits, int pos){
        if(pos>digits.length()-1)
            return;
        char ch=digits.charAt(pos);
        int len=hm.get(digits.charAt(pos)).length;
        int i=0;
        while(i<len){
            combination=combination+hm.get(ch)[i];
            if(combination.length()==digits.length()){
                list.add(combination);
                combination=combination.substring(0,combination.length()-1);
            }  
            if(pos<digits.length())
                combine(digits, pos+1);
            i++;
        }
        if(combination.length()==1 || combination.length()==0)
            combination="";
        else
            combination=combination.substring(0,combination.length()-1);
    } 
}
