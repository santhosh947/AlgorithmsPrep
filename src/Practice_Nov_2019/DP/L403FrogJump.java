package Practice_Nov_2019.DP;

import java.util.*;

class L403FrogJump {
    public static void main(String[] args) {
        int[] st = { 0, 1, 3, 5, 6, 8, 12, 17 };
        int[] s2 = { 0, 1, 2, 3, 4, 8, 9, 11 };

        System.out.println(canCross(st));
        System.out.println(canCross(s2));
    }

    public static boolean canCross(int[] stones) {
        // int[][] p = new int[stones.length][stones.length];

        Map<Integer, HashSet<Integer>> st = new HashMap();
        for (int a = 0; a < stones.length; a++) {
            st.put(stones[a], new HashSet<>());
        }
        HashSet<Integer> in = new HashSet();
        in.add(0);
        st.put(stones[0],in);

        for (int i = 0; i < stones.length - 1; i++) {
            HashSet<Integer> op = st.get(stones[i]);
            Iterator it = op.iterator();
            while (it.hasNext()) {
                int k = (int) it.next();

                int prev = k - 1 + stones[i];
                int curr = k + stones[i];
                int next = k + 1 + stones[i];

                if (st.containsKey(prev) && prev!=stones[i]) {
                    HashSet<Integer> hs = st.get(prev);
                    hs.add(k - 1);
                    st.put(prev,hs);
                }
                if (st.containsKey(curr)&& curr!=stones[i]) {
                    HashSet<Integer> hs = st.get(curr);
                    hs.add(k);
                    st.put(curr,hs);

                }
                if (st.containsKey(next)&& next!=stones[i]) {
                    HashSet<Integer> hs = st.get(next);
                    hs.add(k + 1);
                    st.put(next,hs);

                }
            }


        }
        if(st.get(stones[stones.length-1]).size()==0)
            return false;
        return true;
    }
}