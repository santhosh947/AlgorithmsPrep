package Practice_Nov_2019;

class L785IsGraphBipartite {
    public static void main(String[] args) {
        int[][] a = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(a));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];			
				
        for (int i = 0; i < n; i++) { 
                if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}