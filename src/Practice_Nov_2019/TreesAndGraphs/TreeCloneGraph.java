package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class TreeCloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList());
        Node n2 = new Node(2,new ArrayList());
    
        List<Node> ng = n1.neighbors;
        ng.add(n2);

        ng = n2.neighbors;
        ng.add(n1);
    
        
        Node res = cloneGraph2(n1);  
        System.out.println();
    }

    public static Node cloneGraph(Node node) {
        Node res = null;
        if (node == null)
            return res;

        Map<Node, Node> hm = new HashMap();

        Node t_n = node;
        Stack<Node> st = new Stack();
        st.add(t_n);
        Set<Node> visted = new HashSet();
        while (!st.isEmpty()) {
            Node t = st.pop();
            if (!visted.contains(t)) {
                visted.add(t);
                Node clone_t = hm.containsKey(t) ? hm.get(t) : new Node(t.val, new ArrayList());
                if(res == null)
                    res = clone_t;
                hm.put(t, clone_t);

                List<Node> ng = t.neighbors;
                List<Node> c_ng = clone_t.neighbors;
                for (int i = 0; i < ng.size(); i++) {
                    Node c_n;
                    if (hm.containsKey(ng.get(i))) {
                        c_n = (hm.get(ng.get(i)));
                    } else {
                        c_n = new Node(ng.get(i).val, new ArrayList());
                        hm.put(ng.get(i), c_n);                        
                    }
                    c_ng.add(c_n);
                    st.add(ng.get(i));
                }
                clone_t.neighbors = c_ng;
            }
        }
        return res;
    }


    public static Node cloneGraph_optimal(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }
    
    public static Node clone(Node node, HashMap<Integer, Node> map) {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) 
            return map.get(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) 
            newNode.neighbors.add(clone(neighbor, map));
        return newNode;
    }


    public static Node cloneGraph2(Node node) {
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
}