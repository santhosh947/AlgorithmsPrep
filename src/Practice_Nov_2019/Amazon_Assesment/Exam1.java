package Practice_Nov_2019.Amazon_Assesment;

import java.util.*;

import Prac2.ArrayListEx;

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

class Exam1 {
    private static final int updated = 1;
    private final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    
    public int minimumDays(int rows, int columns, List<List<Integer>> grid)
    {
        int res=-1;
        int outOfDate=0;

        Queue<Point> updatedServers = new ArrayDeque<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                if (grid.get(r).get(c) == updated) {
                    updatedServers.add(new Point(r, c));
                } else {
                    outOfDate++;
                }
            }
        }

        if(outOfDate==0)
            return -1;

        for (int days = 1; !updatedServers.isEmpty(); days++) {
            for (int sz = updatedServers.size(); sz > 0; sz--) {
                    Point pt = updatedServers.poll();
                    for (int[] dir : DIRS) {
                        int r = pt.r + dir[0];
                        int c = pt.c + dir[1];
                        if (isValidPosition(grid, r, c)) {
                            outOfDate--;
                            if (outOfDate == 0) 
                                return days;
                            grid.get(r).set(c, updated);
                            updatedServers.add(new Point(r, c));
                        }
                    }
                }
            }       

        return res;       
    }

    private boolean isValidPosition(List<List<Integer>> grid, int r, int c) {
        return r >= 0 && r < grid.size() &&c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != updated;
    }   
}
}