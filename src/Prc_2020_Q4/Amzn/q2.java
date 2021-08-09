package Prc_2020_Q4.Amzn;

public class q2 {

    public static void main(String[] args) {
        String str = "*|**|*|";

        int[] mem = new int[str.length()];
        int ct = 0;
        for(int i =0;i<mem.length;i++){
            char c = str.charAt(i);
            if(c == '|'){
                mem[i] = ct;
            }else {
                ct++;
            }
        }
        System.out.println();
    }
    
}
