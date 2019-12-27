package Practice_Nov_2019.DP;

import java.util.*;

class Prac_ProrityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        pq.add(3);
        pq.add(4);
        pq.add(5);
        pq.add(3);
        pq.add(2);
        pq.add(6);
        pq.add(2);
        pq.add(2);
        pq.add(1);

        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};

        int r= matrix.length;
        int c = matrix[0].length;
        
        // for(int i=0;i<r;i++)
        // {
        //     for(int j=0;j<c;j++)
        //     {
        //         pq.add(matrix[i][j]);
             
        //     }
        // }

        Iterator it = pq.iterator();

        while(it.hasNext())
        {
            System.out.println(pq.poll());
        }
        
    }
}