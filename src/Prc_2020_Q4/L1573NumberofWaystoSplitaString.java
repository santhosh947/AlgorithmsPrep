package Prc_2020_Q4;

public class L1573NumberofWaystoSplitaString {
    public static void main(String[] args) {
            String str = "0000";

            System.out.println(numWays(str));
    }
    private static final int m = 1_000_000_007;

    public static int numWays(String s) {
        int ct = 0;
        
        int num_one = 0;
        
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            if(c=='1'){
                num_one++;
            }
        }
        if(num_one % 3 !=0)
            return 0;
        
        if(num_one == 0){
            return (int)((s.length() - 2L) * (s.length() - 1L) / 2 % m);

        }
        //3
        int[] store = new int[num_one];
        int idx = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='1'){
                store[idx++]=i;
            }
        }
        int min_one = num_one / 3;
        //10101
        //10
        //101010101010 
        //0101 -> [3,6] 
        //01010 -> [3,7]
        //0,2,4,6,8,10
        // 2
        //Min of s1 = store[min_one - 1] == Pos(2)
        //Max of S1 = store[min_one] - 1 => pos(3)

        //
        //101
        //1010
        //1010, 1010, 
        //2
        //0,2,4
        
        int s1_len_min = 0+ store[min_one-1];
        int s1_len_max = 0+ store[min_one] - 1;
        int s2_len_min = store[min_one*2-1];
        int s2_len_max = store[min_one*2]-1;

        int first_cut = s1_len_max-s1_len_min+1;
        int second_cut = s2_len_max - s2_len_min+1;

        ct = first_cut*second_cut;

        return ct;
        /**
        for(int i=s1_len_min; i<= s1_len_max;i++){
            s1 = s.substring(0, i+1);
            
            
            int j = s1.length();
            int s2_len_min = store[min_one*2-1];
            int s2_len_max = store[min_one*2]-1;

            for(; j<=s2_len_max;j++){
                s2 = s.substring(j, s2_len_min+1);
                int z = s2_len_min+1;
                int s3_len_min = store[min_one*3-1];
                //int s3_len_max = s.length()-1;

              //  for(int z =0; z+s3_len_min<s.length();z++){
                    s3 = s.substring(s2_len_min+1, s.length());
                    String res = s1+s2+s3;
                    if(res.equals(s)){
                        ct++;
                    }
              //  }
           // }
        }
        
        
        /**
        int s1_len = 1;
        int s2_len = 1;
        for(int i = 0;i<s.length()-2 && i < store[min_one]-1; i++){
            s1_len = store[min_one - 1];
            s1_len = s1_len + i;
           //101
            s1 = s.substring(0, s1_len);

            int j = i+s1_len+1;
            for(;j<s.length()-1 && j < store[min_one * 2]-1 ;j++){
                if(store.length > 0){
                    s2_len = store[min_one];
                }
                s2 = s.substring(j, s2_len);
                int z = j+s2_len;
                for(; z<s.length();z++){
                    s3 = s.substring(z, s.length());
                    if(s1+s2+s3 == s){
                        ct++;
                    }
                }
            }
            
        }
        **/
        //return ct;
    }
}
