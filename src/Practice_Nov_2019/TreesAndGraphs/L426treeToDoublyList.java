package Practice_Nov_2019.TreesAndGraphs;

class L426treeToDoublyList {
    public static void main(String[] args) {
        Node r = new Node(4);
        Node l1 = new Node(2);
        Node r1 = new Node(5);

        Node l2 = new Node(1);
        Node r2 = new Node(3);

        r.left = l1;
        r.right = r1;

        l1.left = l2;
        l1.right = r2;

        Node res = treeToDoublyList(r);

        int v = res.val;
        Node t = res.right;
        System.out.print(res.val+"->");
        while(t.val!=v)
        {
            System.out.print(t.val+"->");
            t=t.right;
        }

    }

    private static Node res;
    private static Node prev;

    public static Node treeToDoublyList(Node root) {
        res = null;
       // Node curr = null;
        prev=null;
        
        if(root==null)
            return res;
        
        buildLL(root);
        prev.right = res;
        res.left = prev;
        
        return res;
    }
    
    private static void buildLL(Node r)
    {
        if(r==null)
            return;
        
        if(r.left!=null)
            buildLL(r.left);
        
        if(res==null)
        {
            res=r;
            prev = r;
        }
        else{
          
            prev.right = r;
            r.left=prev;
            prev = r;
        }
        if(r.right!=null)
            buildLL(r.right);
        
        
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}