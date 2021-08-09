package Prc_2020_Q4.Twilio;
import java.util.*;

public class q3 {
    public static void main(String[] args) {
        System.out.println(connectedSum(10, Arrays.asList("1 2","1 3","2 4","3 5","7 8")));

        System.out.println(connectedSum(4, Arrays.asList("1 2","1 4")));

        System.out.println(connectedSum(0, Arrays.asList()));

        System.out.println(connectedSum(1, Arrays.asList()));


    }

    private static int connectedSum(int N, List<String> edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // building graph
        for (String edge: edges) {
            String[] parts = edge.trim().split(" ");
            Integer source = Integer.parseInt(parts[0]);
            Integer destination = Integer.parseInt(parts[1]);

            // adding edge: a -> b
            if(graph.containsKey(source)) {
                Set<Integer> children = graph.get(source);
                children.add(destination);
            } else {
                Set<Integer> children = new HashSet<>();
                children.add(destination);
                graph.put(source, children);
            }

            // adding edge: b -> a
            if(graph.containsKey(destination)) {
                Set<Integer> children = graph.get(destination);
                children.add(source);
            } else {
                Set<Integer> children = new HashSet<>();
                children.add(source);
                graph.put(destination, children);
            }
        }

        //System.out.println(graph.toString());

        // find groups
        int connectedSum = 0;

        HashSet<Integer> visited = new HashSet<>();
        for(int node=1; node <= N; node++) {
            Set<Integer> group = getGroup(node, graph, visited);
            //System.out.println(group.toString());
            if(group != null && group.size() > 0) {
                connectedSum += (int) (Math.ceil(Math.sqrt(group.size())));
            }
        }

        return connectedSum;
    }

    private static Set<Integer> getGroup(int node, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        Set<Integer> group = new HashSet<>();
        if (visited.contains(node)) {
            return group;
        }

        Queue<Integer> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(node);
        group.add(node);

        while(!nodesToVisit.isEmpty()) {
            Integer currentNode = nodesToVisit.remove();
            visited.add(currentNode);
            Set<Integer> children = graph.get(currentNode);
            if(children != null) {
                for(Integer child: children) {
                    if(!visited.contains(child)) {
                        group.add(child);
                        nodesToVisit.add(child);
                    }
                }
            }
        }

        return group;
    }

    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {

        //Map<Integer
        return 0;
    }
    
}
