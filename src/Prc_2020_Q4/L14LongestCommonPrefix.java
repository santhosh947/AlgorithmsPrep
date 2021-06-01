package Prc_2020_Q4;

public class L14LongestCommonPrefix {
    public static void main(String[] args) {
String[] s = {"cir", "car"};
//System.out.println(longestCommonPrefix(s));

int[][] l = {{2,3},{8,2}};
System.out.println(streetLights(8, l));
    }

    public static int streetLights(int n, int[][] lights) {
        int[][] l_with_r = new int[lights.length][2];
        
        for(int i = 0;i<lights.length;i++){
            l_with_r[i][0] = lights[i][0]-lights[i][1];
            l_with_r[i][1] = lights[i][0]+lights[i][1];        
        }
        
        int pointer = 0;
        int prev_pointer = 0;
        int m = n+1;
        
        int count  = 0;
        
        int idx = 0;
        
        while(pointer <m && idx < lights.length){
            int l_range = l_with_r[idx][0];
            int r_range = l_with_r[idx][1];
            if(l_range > pointer && count==0){
                return -1;
            }else if(r_range > pointer && l_range <= pointer){
                if(l_range <= prev_pointer && count >0){
                    count--;
                    pointer = prev_pointer;                    
                }
                prev_pointer = pointer;
                pointer = l_with_r[idx][1];
                count++;
            }
            else{
                idx++;
                continue;
            }
            idx++;
        }
        
        return pointer < n || count == 0 ? -1 : count;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) 
           return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
            return pre;
    }
    
    
}
