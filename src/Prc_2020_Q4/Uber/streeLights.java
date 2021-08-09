package Prc_2020_Q4.Uber;

import java.util.*;

public class streeLights {
    public static void main(String[] args) {
        int[][] lights = {{0,5},{1,3},{5,4},{8,3}};
        System.out.println(streetLights(10, lights));
    }

    public static int ct;

    public static int streetLights(int n, int[][] lights){
        ct = -1;
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] lowerBound = new int[lights.length];
        
        for(int i=0;i< lights.length;i++){
            int pt = lights[i][0];
            int range = lights[i][1];

            lights[i][0] = pt-range;
            lights[i][1] = pt+range;

            lowerBound[i]= pt-range;

            lookup.put(lights[i][0], lights[i][1]);
        }

        Arrays.sort(lowerBound);
        
        ct = getCount(lowerBound, lookup, 0,0, n, -1);

        return ct;
    }

    private static int getCount(int[] lowerBound, Map<Integer, Integer> lookup, int idx,int range, int n, int count) {
        int v1 = lowerBound[idx];
        if(v1 < range){
            return -1;
        }

        while(lowerBound[idx] <= range){
            //count++;
            getCount(lowerBound, lookup, idx+1, range, n,count+1);

        }
        return 0;
    }
}
