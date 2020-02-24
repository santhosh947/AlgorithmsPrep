package Practice_Nov_2019.Array;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class L56MergeIntervals {
    /**
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * 
     * 
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * 
     */
    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] b = {{1,4},{4,5}};

        int[][] res = merge(b);

        for(int i=0;i<res.length;i++)
        {
            System.out.println("{"+res[i][0]+","+res[i][1]+"}");            
        }
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <2)
            return intervals;

        int r = intervals.length;

        int[] st = new int[r];
        int[] end = new int[r];

        for(int i=0;i<r;i++)
        {
            st[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }

        Arrays.sort(st);
        Arrays.sort(end);

        List<int[]> res = new ArrayList();

        int j=0;
        for(int i=0;i<r-1;i++)
        {
            if(st[i+1]>end[i])
            {
                int[] t = {st[j],end[i]};
                res.add(t);
                j=i+1;
            }
        }

        int[] t = {st[j],end[r-1]};
        res.add(t);

        int[][] ans = new int[res.size()][2];
        for(int i=0;i<res.size();i++)
        {
            ans[i][0]=res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    
    }    


    public static int[][] merge_prac(int[][] intervals) {
        int[] f = new int[intervals.length];
        int[] b = new int[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            f[i]=intervals[i][0];
            b[i]=intervals[i][1];
        }
        Arrays.sort(f);
        Arrays.sort(b);
        
        List<ArrayList<Integer>> res = new ArrayList();
        int start = f[0];
        int ct =0;
        for(int i=0;i<intervals.length && ct<intervals.length;i++)
        {
            while(i<intervals.length && f[i]<b[ct])
            {
                i++;
            }
            while(ct<intervals.length && f[i]>=b[ct])
            {
                ct++;
            }
            
                ArrayList<Integer> r= new ArrayList();
                r.add(start);
                r.add(b[ct-1]);
                res.add(r);
                start=f[i];
                //ct++;

            
            
        }
        ArrayList<Integer> r= new ArrayList();
        r.add(start);
        r.add(b[ct]);
        res.add(r);
        int rl = res.size();
            int[][] aa = new int[rl][2];
        for(int i=0;i<rl;i++)
        {
            aa[i][0]=res.get(i).get(0);
            aa[i][1]=res.get(i).get(1);
        }
        return aa;
            
    }
}