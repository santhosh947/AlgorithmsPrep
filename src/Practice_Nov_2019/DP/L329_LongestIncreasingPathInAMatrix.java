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

        System.out.println(longestIncreasingPath_DFS(in));
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

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;
    public static int longestIncreasingPath_DFS(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }


    public static int longestIncreasingPath_op(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                for (int[] d: dirs)
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                        outdegree[i][j]++;

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j)
                if (outdegree[i][j] == 0) 
                    leaves.add(new int[]{i, j});

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d:dirs) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y])
                        if (--outdegree[x][y] == 0)
                            newLeaves.add(new int[]{x, y});
                }
            }
            leaves = newLeaves;
        }
        return height;
    }

}