package Practice_Nov_2019.HashTables;

import java.util.*;

class L957PrisonCellsAfterNDays {
    public static void main(String[] args) {
        int[] c = {1,0,0,1,0,0,1,0};

//1000000000
        int[] res = prisonAfterNDays(c, 1000000000);

        for (int a : res) {
            System.out.print(a + ",");
        }
        System.out.println();
        res = prisonAfterNDays2(c, 1000000000);

        for (int a : res) {
            System.out.print(a + ",");
        }
    }

    public static int[] prisonAfterNDays2(int[] cells, int N) {
		if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>(); 
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
        return cells;
    }
    
    private static int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }


    public static int[] prisonAfterNDays(int[] cells, int N) {
        // int[] cp = new int[cells.length];
        HashSet<String> hs = new HashSet();
        int c = 0;
        boolean hascycle = false;
        for (int a = 0; a < N; a++) {

            int i = 0;
            int prev = cells[i];
            i++;
            int curr = -1;
            for (i = 1; i < cells.length - 1; i++) {
                curr = cells[i];
                int next = cells[i + 1];
                if (next == prev) {
                    prev = curr;
                    cells[i] = 1;
                } else {
                    prev = curr;
                    cells[i] = 0;
                }
            }
            cells[0] = 0;
            cells[cells.length - 1] = 0;
            String str = Arrays.toString(cells);

            if (hs.contains(str)) {
                hascycle = true;
                break;
            } else {
                c++;
                hs.add(str);
            }
        }
        if (hascycle) {
            int n = N % c;
            for (int a = 0; a < n; a++) {

                int i = 0;
                int prev = cells[i];
                i++;
                int curr = -1;
                for (i = 1; i < cells.length - 1; i++) {
                    curr = cells[i];
                    int next = cells[i + 1];
                    if (next == prev) {
                        prev = curr;
                        cells[i] = 1;
                    } else {
                        prev = curr;
                        cells[i] = 0;
                    }
                }
                cells[0] = 0;
                cells[cells.length - 1] = 0;

            }
        }
        return cells;
    }
}