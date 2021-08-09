package Prc_2020_Q4.Twilio;

import java.util.*;

public class NumberWithCodes {
    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        List<String> nums = new ArrayList<>();

        codes.add("twlo");
        codes.add("code");
        codes.add("htch");

        nums.add("+17474824380");
        nums.add("+14157088956");
        nums.add("+919810155555");
        nums.add("+15109926333");
        nums.add("+1415123456");

        List<String> res = phoneNumbersWithCodes(codes, nums);

        for(String r : res){
            System.out.println(r);
        }

    }

    public static List<String> phoneNumbersWithCodes(List<String> codes, List<String> numbers) {

        List<String> res = new ArrayList<>();

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        Map<Character, Integer> map2 = new HashMap<>();
        map2.put('a',2);
        map2.put('b',2);
        map2.put('c',2);

        map2.put('d',3);
        map2.put('e',3);
        map2.put('f',3);

        map2.put('g',4);
        map2.put('h',4);
        map2.put('i',4);

        map2.put('j',5);
        map2.put('k',5);
        map2.put('l',5);

        map2.put('m',6);
        map2.put('n',6);
        map2.put('o',6);

        map2.put('p',7);
        map2.put('q',7);
        map2.put('r',7);
        map2.put('s',7);

        map2.put('t',8);
        map2.put('u',8);
        map2.put('v',8);

        map2.put('w',9);
        map2.put('x',9);
        map2.put('y',9);
        map2.put('z',9);

        Set<String> code_seq = new HashSet<>();

        for(String code : codes){
            char[] ch_arr = code.toCharArray();
            StringBuilder code_to_num = new StringBuilder();
            for(Character c: ch_arr){

                if(map2.containsKey(c)){
                    code_to_num.append(String.valueOf(map2.get(c)));
                }

            }

            code_seq.add(code_to_num.toString());
            
        }

        for(String num : numbers){
            for(String code: code_seq){
                if(num.contains(code)){
                    res.add(num);
                }
            }
        }
        return res;

    }
}
