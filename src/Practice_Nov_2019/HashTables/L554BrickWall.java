package Practice_Nov_2019.HashTables;

import java.util.*;

class L554BrickWall {
    public static void main(String[] args) {

        List<Integer> r1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> r2 = Arrays.asList(3, 1, 2);
        List<Integer> r3 = Arrays.asList(1, 3, 2);
        List<Integer> r4 = Arrays.asList(2, 4);
        List<Integer> r5 = Arrays.asList(3, 1, 2);
        List<Integer> r6 = Arrays.asList(1, 3, 1, 1);
        List<List<Integer>> wall = Arrays.asList(r1, r2, r3, r4, r5, r6);

        System.out.println(leastBricks_op(wall));

    }

    public static int leastBricks2(List<List<Integer>> wall) {

        if (wall == null || wall.size() == 0)
            return 0;

        int res = wall.size();

        List<Integer> r1 = wall.get(0);
        int len = 0;

        for (int t : r1) {
            len += t;
        }
        int l = 1;
        while (l < len - 1) {
            for (int i = 0; i < wall.size(); i++) {

            }
        }

        return res;

    }

    public static int leastBricks_op(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }

    public static int leastBricks(List < List < Integer >> wall) {
        int[] pos = new int[wall.size()];
        int c = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int el: wall.get(0))
            sum += el;
        while (sum != 0) {
            int count = 0;
            for (int i = 0; i < wall.size(); i++) {
                List < Integer > row = wall.get(i);
                if (row.get(pos[i]) != 0)
                    count++;
                else
                    pos[i]++;
                row.set(pos[i], row.get(pos[i]) - 1);
            }
            sum--;
            res = Math.min(res, count);
        }
        return res;
    }
}