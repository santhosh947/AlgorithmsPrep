package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L207CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }};
        System.out.println(canFinish(2, prerequisites));

        int[] res = findOrder(2, prerequisites);
        for(int r: res)
        {
            System.out.print(r +",");
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int n = numCourses;
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

        for (int[] pr : prerequisites) {
            List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]);
            indegree[pr[0]]++;
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (indegree[cur] == 0) {
                count++;
                st.add(cur);
            }
            if (!adj.containsKey(cur))
                continue;
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    q.add(nei);
            }

        }

        if (count == n) {
            while(!st.isEmpty())
            {
                res[st.size()-1] = st.pop();
            }
            return res;
        }
        return null;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

        for (int[] pr : prerequisites) {
            List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]);
            indegree[pr[0]]++;
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (indegree[cur] == 0)
                count++;
            if (!adj.containsKey(cur))
                continue;
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    q.add(nei);
            }

        }

        return count == n;
    }
}