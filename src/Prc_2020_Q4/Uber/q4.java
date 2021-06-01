package Prc_2020_Q4.Uber;
import java.util.*;

class DL{
    int val;
    DL left;
    DL right;

    DL(int v){
        val = v;
    }
}

public class q4 {
    public static void main(String[] args) {
        int[][] pairs = {{3,5},{1,4},{2,4},{1,5},{2,3}};

        int[] res = restoreNumbers(pairs);

        for(int i: res){
            System.out.println(i);
        }

        //3-5 1-4-2
    }

    public static int[] restoreNumbers(int[][] pairs){
        int[] res = null;
        Map<Integer, DL> mapping = new HashMap();
        DL head = null;
        for(int i=0;i<pairs.length;i++){
            int v1 = pairs[i][0];
            int v2 = pairs[i][1];

            if(mapping.containsKey(v1)){
                DL nd = mapping.get(v1);
                DL nd_v2 = mapping.containsKey(v2) ? mapping.get(v2) : new DL(v2);

                if(nd.left == null){
                    if(nd_v2.right == null){
                        nd_v2.right = nd;
                        nd.left = nd_v2;
                    }
                }else if(nd.right == null){
                    if(nd_v2.left == null){
                        nd_v2.left = nd;
                        nd.right = nd_v2;
                    }
                }

            }else if(mapping.containsKey(v2)){
                DL nd = mapping.get(v2);
                DL nd_v1 = new DL(v1);
                if(nd.left == null){
                    nd.left = nd_v1;
                    nd_v1.right = nd;
                }
                else if(nd.right == null){
                    nd.right = nd_v1;
                    nd_v1.left = nd;
                }
                mapping.put(v1, nd_v1);
            }else{
                DL DL_v1 = new DL(v1);
                DL DL_v2 = new DL(v2);

                DL_v1.right = DL_v2;
                DL_v2.left = DL_v1;
                if(head == null){
                    head = DL_v1;
                }
                mapping.put(v1, DL_v1);
                mapping.put(v2, DL_v2);
            }
        }

        DL temp_head = head;
        int size = mapping.size();
        int idx = 0;
        res = new int[mapping.size()];
        while(size>0){
            res[idx] = temp_head.val;
            temp_head = temp_head.right;
            idx++;
            size--;
        }
        return res;        
    }
}
