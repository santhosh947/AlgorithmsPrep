package Practice_Nov_2019.DP;

import java.util.*;

class pos {
    int i;
    int j;

    pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class L329_LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] in = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        int[][] in2 = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        int[][] in3 = {{}};

        System.out.println("******************************************");

        System.out.println(longestIncreasingPath(in3));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        if(matrix==null)
            return res;
      
      
        if(matrix.length == 0)
            return 0;
        int r = matrix.length;
        int c = matrix[0].length;

        if(r+c == 0)
            return 1;
    
        PriorityQueue<Integer> qu = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        Map<Integer, List<pos>> hm = new HashMap();

      
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                qu.add(matrix[i][j]);
                List<pos> ll = hm.containsKey(matrix[i][j]) ? hm.get(matrix[i][j]) : new ArrayList();

                ll.add(new pos(i, j));

                hm.put(matrix[i][j], ll);
            }
        }
        // qu.addAll(eles);

        int[][] temp = new int[r][c];

        Iterator it = qu.iterator();
        while (it.hasNext()) {
            int elem = (int) qu.poll();

            if (hm.containsKey(elem)) {
                List<pos> places = hm.get(elem);

                for (int k = 0; k < places.size(); k++) {
                    int t_i = places.get(k).i;
                    int t_j = places.get(k).j;
                    int path = findPath(matrix, temp, t_i, t_j);
                    res = Math.max(res, path);
                    temp[t_i][t_j] = path;
                }
                hm.remove(elem);
            }

        }

        return res;

    }

    public static int findPath(int[][] mat, int[][] temp, int i, int j) {

        int rig = (j < mat[0].length - 1 && mat[i][j + 1] > mat[i][j]) ? temp[i][j + 1] : 0;
        int left = (j > 0 && mat[i][j - 1] > mat[i][j]) ? temp[i][j - 1] : 0;

        int up = (i > 0 && mat[i - 1][j] > mat[i][j]) ? temp[i - 1][j] : 0;
        int down = (i < mat.length - 1 && mat[i + 1][j] > mat[i][j]) ? temp[i + 1][j] : 0;

        return Math.max(Math.max(1 + rig, 1 + left), Math.max(1 + up, 1 + down));
    }

}