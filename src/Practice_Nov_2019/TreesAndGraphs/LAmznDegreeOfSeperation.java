package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class LAmznDegreeOfSeperation {
    private static class GraphNode {
        int val;

        List<GraphNode> neighbors;

        public GraphNode(int x) {
            val = x;
            neighbors = new ArrayList<GraphNode>();
        }
    }

    public static void main(String[] args) {

    }

    public static int sixDegrees(List<GraphNode> graph, GraphNode s, GraphNode t) {
        if(s==t)
            return 0;


        Map<GraphNode, Integer> visited = new HashMap();
        Queue<GraphNode> qu = new LinkedList();

        qu.add(s);
        visited.put(s,0);
        while(!qu.isEmpty())
        {
            GraphNode curr = qu.poll();
            int size = curr.neighbors.size();

            for(int i=0;i<size;i++)
            {
                GraphNode ng = curr.neighbors.get(i);
                if(visited.containsKey(ng))
                {
                    continue;
                }
                if(ng==t)
                {
                    return visited.get(curr)+1;
                }
                qu.add(ng);
                visited.put(ng,visited.get(curr)+1);
            }
        }
        return -1;
    }
}