package Practice_Nov_2019.MockInterviews_LeetCode.FB;

import java.util.ArrayList;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Exam2 {

    public static void main(String[] args) {
        int[][] in = { {0,1,0,0}, { 1,1,1,0 }, { 0,1,0,0},{1,1,0,0} };
        int[][] in1 = { { 1 } };
        int[][] in2 = { { 1,1 },{1,1} };


        // System.out.println(islandPerimeter(in));
        // System.out.println(islandPerimeter(in1));
        System.out.println(islandPerimeter2(in2));


        // ListNode a0 = new ListNode(1);
        // ListNode a1 = new ListNode(2);
        // ListNode a2 = new ListNode(3);
        // ListNode a3 = new ListNode(4);
        // ListNode a4 = new ListNode(5);

        // a0.next = a1;
        // a1.next = a2;
        // a2.next = a3;
        // a3.next = a4;

        // ListNode t = a0;
        // while (t != null) {
        //     System.out.print(t.val + "->");
        //     t = t.next;
        // }

        // System.out.println();

        // reorderList(a0);

        // t = a0;
        // while (t != null) {
        //     System.out.print(t.val + "->");
        //     t = t.next;
        // }

        // System.out.println();

    }

    public static int islandPerimeter2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) 
                        num++; // UP
                    if (j == 0 || grid[i][j - 1] == 0) 
                        num++; // LEFT
                    if (i == rows -1 || grid[i + 1][j] == 0) 
                        num++; // DOWN
                    if (j == cols -1 || grid[i][j + 1] == 0) 
                        num++; // RIGHT
                }
            }
        }
        return num;
    }

    public static Node cloneGraph(Node node) {
        if(node ==null)
            return null;
        
        Map<Node, Node> hm = new HashMap();
        
        Node t = node;
        Stack<Node> st = new Stack(); 
        st.push(t);
        while(!st.isEmpty())
        {
            Node process = st.pop();
            
            
            if(hm.containsKey(process))
            {
                continue;
            }
            else
            {
                List<Node> ng = process.neighbors;
                for(int i=0;i<ng.size();i++)
                {
                    st.push(ng.get(i));
                }
                List<Node> ll = new ArrayList<>();
                hm.put(process, new Node(process.val,ll));
            }            
        }

        Iterator hmIterator = hm.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            Node k = (Node)mapElement.getKey();
            List<Node> k_ng = k.neighbors;
            Node v = (Node)mapElement.getValue(); 
            List<Node> v_ng = v.neighbors;

            for(int i=0;i<k_ng.size();i++)
            {
                Node ng = k_ng.get(i);
                Node vng = hm.get(ng);
                v_ng.add(vng);
            }

            v.neighbors = v_ng;

            hm.put(k,v);

        }

        return hm.get(node);       
            
    }

    public static void reorderList(ListNode head) {
        if(head ==null)
            return;

        ListNode t = head;

        List<ListNode> st = new ArrayList();
        int a =0;

        while(t!=null)
        {
            st.add(a, t);
            t=t.next;
            a++;
        }

        t = head;

        int n = st.size();
        int ind=1;
        int len = st.size();
        while(ind<=len/2 && t!=null)
        {
            ListNode nn = st.get(n-1);
            ListNode tmp = t.next;
            if(tmp==nn)
            {
                tmp.next=null;
                return;
            }
            t.next = nn;
            nn.next=tmp;
            t=t.next.next;
            n--;
            ind++;        
        }
        t.next=null;
        
    }

    public static int sum = 0;

    public static int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum=0;
                if (grid[i][j] == 1) {
                   sum=2;
                   dfs(grid, i, j);
                   return sum;
                }
            }
        }
        return sum;
    }

    public static void dfs(int[][] g, int i, int j) {
        int r = g.length;
        int c = g[0].length;

        if (i >= r || i < 0 || j >= c || j < 0 || g[i][j] == 0 || g[i][j]==2)
            return;

        if (g[i][j] == 1) {
            sum = sum+2;
        }
        if(g[i][j]==2) {
            sum -= 2;
        }
        g[i][j] = 2;
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}