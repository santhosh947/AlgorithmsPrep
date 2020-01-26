package Practice_Nov_2019;

import java.util.*;

class point {
    int i;
    int j;

    point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class MazeProblem {
    public static void main(String[] args) {
        int[][] g1 = { { 1, 0, 1, 1 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
        int[][] g2 = { { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 0, 0 } };

        System.out.println(hasPath_op(g1));
        System.out.println(hasPath_op(g2));

        // int[][] g3 = { { 1, 1, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 1 } };
        // System.out.println(hasPath1(g3, 1));

        // int[][] g4 = { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 1 } };
        // System.out.println(hasPath1(g4, 1));

    }

    public static boolean hasPath_op(int[][] g) {
        int r = g.length;
        int c = g[0].length;

        boolean[][] vist = new boolean[r][c];
        int prev_val = g[r-1][c-1];
        int next_val = Math.abs(g[r-1][c-1] - 1);
        boolean prev = true;
        vist[r-1][c-1] = true;

        point prev_point = new point(r-1,c-1);
        Stack<point> st = new Stack<>();
        st.add(prev_point);
        vist[r-1][c-1]=true;

        while(!st.isEmpty())
        {
            point pos = st.pop();
            int p_i = pos.i;
            int p_j = pos.j;
            next_val = Math.abs(g[p_i][p_j] - 1);

            p_i=p_i-1;
            // boolean left=false;
            // boolean top = false;
            //top            
            if(isValid(p_i,p_j,r,c) && !vist[p_i][p_j])
            {
                if(next_val==g[p_i][p_j] && p_i==0 && p_j==0)
                {
                    return true;
                }
                if(next_val==g[p_i][p_j])
                {
                    st.add(new point(p_i, p_j));
                    vist[p_i][p_j]=true;
                   // top=true;
                }
            }

            p_i = pos.i;
            p_j = pos.j-1;
            //left            
            if(isValid(p_i,p_j,r,c) && !vist[p_i][p_j])
            {
                if(next_val==g[p_i][p_j] && p_i==0 && p_j==0)
                {
                    return true;
                }
                if(next_val==g[p_i][p_j])
                {
                    st.add(new point(p_i, p_j));
                    vist[p_i][p_j]=true;
                   // top=true;
                }
            }
        }
        return vist[0][0];
    }

    public static boolean hasPath(int[][] g) {
        int r = g.length;
        int c = g[0].length;

        boolean[][] vist = new boolean[r][c];
        int next_val = Math.abs(g[0][0] - 1);
        boolean prev = true;
        vist[0][0] = true;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // if (!vist[i][j]) {
                next_val = Math.abs(g[i][j] - 1);
                boolean top = false;
                boolean left = false;
                // check down
                if (isValid(i + 1, j, r, c) && vist[i][j]) {

                    top = g[i + 1][j] == next_val ? true : false;
                }
                // go right
                if (isValid(i, j + 1, r, c) && vist[i][j]) {
                    left = g[i][j + 1] == next_val ? true : false;
                }

                vist[i][j] = (top || left);
                if (!top && !left)
                    return false;
                // }
            }
        }
        return vist[0][0];
    }

    public static boolean hasPath1(int[][] g, int coin) {
        if (g[0][0] != coin)
            return false;

        int r = g.length;
        int c = g[0].length;
        Stack<point> st = new Stack();
        st.add(new point(0, 0));
        int[][] visited = new int[r][c];
        while (!st.isEmpty()) {
            point pos = st.pop();
            int i_next = pos.i + 1;
            int j_next = pos.j;
            if (isValid(i_next, j_next, r, c) && visited[i_next][j_next] == 0) {
                if (g[i_next][j_next] == coin && i_next == r - 1 && j_next == c - 1) {
                    return true;
                }
                if (g[i_next][j_next] == coin) {
                    st.add(new point(i_next, j_next));
                }
                visited[i_next][j_next] = 1;
            }
            i_next = pos.i;
            j_next = pos.j + 1;
            if (isValid(i_next, j_next, r, c) && visited[i_next][j_next] == 0) {
                if (g[i_next][j_next] == coin && i_next == r - 1 && j_next == c - 1) {
                    return true;
                }
                if (g[i_next][j_next] == coin) {
                    st.add(new point(i_next, j_next));
                }
                visited[i_next][j_next] = 1;
            }
        }
        return false;
    }

    private static boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c) {
            return false;
        }
        return true;
    }
}