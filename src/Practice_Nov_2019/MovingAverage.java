package Practice_Nov_2019;

import java.util.*;

class MovingAverage {

    public static double ct = 0;
    public static double running_tot = 0;
    public static int s = 0;
    public static Queue<Integer> qu;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        running_tot = 0;
        s = size;
        qu = new LinkedList();
        ct = 0;

    }

    public static double next(int val) {
        qu.add(val);
        running_tot += (double) val;
        ct += 1;
        if (ct < s) {
            return running_tot / ct;
        } else {
            int temp = qu.size() > s ? qu.remove() : 0;
            running_tot = (running_tot - (double) temp);
            return running_tot / (double) s;
        }
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> hm = new HashMap();

        for (int i = 0; i < dominoes.length; i++) {

            int a = dominoes[i][0];
            int b = dominoes[i][1];           

            int num = Math.min(a,b) *10 + Math.max(a,b);
            int c = hm.getOrDefault(num,0);
            res+=c;
            hm.put(num,c+1);
          
        }

        return res;
    }

    public static int numEquivDominoPairs2(int[][] dominoes) {
        int res = 0;
        // int[] processed = new int[dominoes.length];
        // int jump = -1;
        Map<int[][], List<Integer>> hm = new HashMap();

        for (int i = 0; i < dominoes.length - 1; i++) {

            int[][] k = new int[1][1];
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            k[0][0] = a;
            k[0][1] = b;
            if (!hm.containsKey(k)) {
                for (int j = i + 1; j < dominoes.length; j++) {
                    int c = dominoes[j][0];
                    int d = dominoes[j][1];

                    if ((a == c && b == d) || (a == d && b == c)) {
                        List<Integer> val = hm.getOrDefault(k, new ArrayList());
                        val.add(j);
                        dominoes[j][0] = a;
                        dominoes[j][1] = b;
                        res++;
                    }
                }
            }
            Iterator hmIterator = hm.entrySet().iterator();

            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry) hmIterator.next();
                List<Integer> val = (List<Integer>) mapElement.getKey();

            }
        }

        return res;
    }
}