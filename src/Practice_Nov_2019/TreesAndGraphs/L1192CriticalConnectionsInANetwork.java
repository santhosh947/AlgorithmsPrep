package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L1192CriticalConnectionsInANetwork {

    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList();
        List<Integer> l = new ArrayList();
        l.add(0);
        l.add(1);

        List<Integer> l2 = new ArrayList();
        l2.add(1);
        l2.add(2);

        List<Integer> l3 = new ArrayList();
        l3.add(2);
        l3.add(0);

        List<Integer> l4 = new ArrayList();
        l4.add(1);
        l4.add(3);

        ls.add(l);
        ls.add(l2);
        ls.add(l3);
        ls.add(l4);
        List<List<Integer>> res = criticalConnections(4, ls);

        for (int i = 0; i < res.size(); i++) {
            List<Integer> ll = res.get(i);
            for (int t : ll) {
                System.out.print(t + ",");
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashSet<List<Integer>> edges = new HashSet();
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(List<Integer> connection : connections){
            if(connection.get(0) > connection.get(1)){
                int temp = connection.get(0);
                connection.set(0, connection.get(1));
                connection.set(1, temp);
            }
            edges.add(connection);
            List list = graph.computeIfAbsent(connection.get(0), k -> new ArrayList());
            list.add(connection.get(1));
            list = graph.computeIfAbsent(connection.get(1), k -> new ArrayList());
            list.add(connection.get(0));
        }
        int[] rank = new int[n];
        /*Not use -1, prevent node 0 checking previous node visited*/
        Arrays.fill(rank, -2);
        backtrack(edges, graph, rank, 0, 0);
        return new ArrayList(edges);
    }
    
    public static int backtrack(HashSet<List<Integer>> edges, HashMap<Integer, List<Integer>> graph, int[] rank, int node, int height){
        if(rank[node] >= 0) 
        	return rank[node];
        rank[node] = height;
        int min_height = height;
        for(Integer neighbor : graph.get(node)){
            /*Check previous node visited*/
            if(rank[neighbor] == height - 1) 
            	continue;
            int feedback = backtrack(edges, graph, rank, neighbor, height + 1);
            min_height = Math.min(min_height, feedback);   
            if(feedback <= height){
                edges.remove(Arrays.asList(Math.min(neighbor, node), Math.max(neighbor, node)));
            }
        }
        return min_height;
    }

    public static List<List<Integer>> criticalConnections_self(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList();

        Map<Integer, Set<Integer>> st = new HashMap<Integer, Set<Integer>>();
        Set<Integer> singleDegree = new HashSet();
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> l = connections.get(i);

            int n1 = l.get(0);
            int n2 = l.get(1);
            Set<Integer> hs = new HashSet();
            if(st.containsKey(n1))
            {
                hs = st.get(n1);                
            }
            hs.add(n2);
            st.put(n1,hs);
            if(hs.size()==1)
            {
                singleDegree.add(n1);
            }
            if(hs.size()>1)
            {
                singleDegree.remove(n1);
            }

            Set<Integer> hs2 = new HashSet();
            if(st.containsKey(n2))
            {
                hs2 = st.get(n2);                
            }
            hs2.add(n1);
            st.put(n2,hs2);

            if(hs2.size()==1)
            {
                singleDegree.add(n2);
            }
            if(hs2.size()>1)
            {
                singleDegree.remove(n2);
            }

        }

        Iterator it = singleDegree.iterator();

        while(it.hasNext())
        {
            List<Integer> r1 = new ArrayList();
            int ele = (int)it.next();
            r1.add(ele);
            r1.add(st.get(ele).iterator().next()); 
            res.add(r1);           
        }
        return res;
    }
}