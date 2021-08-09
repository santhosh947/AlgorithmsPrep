package Prc_2020_Q4.Twilio;
import java.util.*;

public class romanNumerals {
    public static void main(String[] args) {
        String[] names = {"Louis V", "Louis VI", "Louis X", "Peter I"};
        String[] res = sortNames(names);

    }

    

    public static String[] sortNames(String[] names){
        String[] res = new String[names.length];
        String[] onlyName = new String[names.length];
        int[] nums = new int[names.length];

        int idx =0;
        for(String name: names){
            onlyName[idx] = name.split(" ")[0];
            nums[idx] = romanToInt(name.split(" ")[1]);
            idx++;
        }

        Arrays.sort(onlyName);
        Arrays.sort(nums);


        return res;
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
		    return -1;
        Map<Character, Integer> map= new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        //char[] ch_arr= s.toCharArray();
        
        int res = 0;
        int prev = 0;
        int curr = 0;
        
       // for(int i=ch_arr.length-1;i>-1;i--){
        for(int i=s.length()-1;i>-1;i--){

            curr = map.get(s.charAt(i));
            if(curr>= prev){
                res+=curr;
            }else{
                res-=curr;
            }
            prev = curr;            
        }        
        return res;
    }
}
