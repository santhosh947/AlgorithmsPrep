package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class LNodeDependencies {
    // public static void main(String[] args) {
    //     int[][] nodes =  {{7,11}, {5,11}, {3,8}, {11,2}, {11,9}, {8,9},{3,10}};
    //     System.out.println(findNodes(nodes, 2));
    // }
    
    // private static List<Integer> findNodes(int[][] nodes, int startNode) {
    //     List<Integer> res = new ArrayList<>();
    //     Map<Integer, HashSet<Integer>> map = new HashMap<>();
    //     for(int[] n : nodes) {
    //         map.putIfAbsent(n[1], new HashSet<>());
    //         map.get(n[1]).add(n[0]);
    //     }
    //     Set<Integer> visited = new HashSet<>();
    //     bfs(map, res, visited, startNode);
    //     Collections.reverse(res);
    //     return res;
    // }
    
    // private static void bfs(Map<Integer, Set<Integer>> map, List<Integer> res, Set<Integer> visited, int startNode) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(startNode);
    //     while(!q.isEmpty()) {
    //         int cur = q.poll();
    //         if(!visited.contains(cur)) {
    //             visited.add(cur);
    //             res.add(cur);
    //             for(int nei : map.getOrDefault(cur, new HashSet<>())) {
    //                 if(!visited.contains(nei)) {
    //                     q.offer(nei);
    //                 }
    //             }
    //         }
    //     }
    // }
}