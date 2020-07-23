package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

import Prac2.productExceptItself;

public class L272ClosestBinarySearchTreeValueII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Integer[] sourceArray = { 1,2,3,null,4};
        List<Integer> targetList = Arrays.asList(sourceArray);   
        
        TreeNode root = buildTree(targetList);
       // System.out.println(root.val);

       System.out.println(isCousins(root,2,3));
    
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> Processingst = new LinkedList<>();
        Processingst.add(root);
        int sz=0;
        while (Processingst.size() > 0) {
            List<Integer> ll = new ArrayList<>();
            sz = Processingst.size();

            while (Processingst.size() > 0 && sz>0 ) {
                TreeNode nd = Processingst.poll();
                if (nd != null) {
                    ll.add(nd.val);
                    if (nd.left != null)
                        Processingst.add(nd.left);

                    if (nd.right != null)
                        Processingst.add(nd.right);
                }
                sz--;
            }

            res.add(ll);
        }

        return res;
    }

    public static TreeNode buildTree(List<Integer> nds)
    {
        TreeNode r = null;
        if(nds.size()==0)
            return r;

        r = new TreeNode(nds.get(0));
        Queue<TreeNode> st = new LinkedList();
        int i=1;
        st.add(r);

        while(st.size()>0 && i<nds.size())
        {
            TreeNode nd = st.poll();
            for(int j=0;j<1;j++)
            {
                TreeNode left_nd = nds.get(i+j)==null ? null : new TreeNode(nds.get(i+j));
                TreeNode right_nd =nds.get(i+j+1)==null ? null :new TreeNode(nds.get(i+j+1));
                i=i+2;
                nd.left=left_nd;
                nd.right=right_nd;
                if(left_nd!=null)
                    st.add(left_nd);
                
                if(right_nd!=null)
                    st.add(right_nd);

            }
        }

        return r;
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null)
            return true;

        List<TreeNode> X_path = findNode(root,x);
        List<TreeNode> y_path = findNode(root, y);
        if(X_path.size()!= y_path.size() || X_path.size()<3 || X_path.get(1)==y_path.get(1))
            return false;
        
        return true;
    }

    private static List<TreeNode> findNode(TreeNode root, int a) {
        List<TreeNode> res = new ArrayList();
        traverse(root, a, res);
        return res;
	}

	private static boolean traverse(TreeNode root, int a, List<TreeNode> res) {
        if(root==null)
            return false;
        
        if(root.val==a)
        {
            res.add(root);
            return true;
        }
        boolean lFound=traverse(root.left, a, res);
        boolean rFound=traverse(root.right, a, res);
        if(lFound || rFound)
        {
            res.add(root);
            return true;
        }

        return false;     
        
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode> Processingst = new Stack();
        Stack<TreeNode> Node_Stack = new Stack();
        Processingst.add(root);
        boolean reverse = true;
        while (Processingst.size() > 0 || Node_Stack.size() > 0) {
            List<Integer> ll = new ArrayList<>();

            if (reverse) {
                while (Processingst.size() > 0) {
                    TreeNode nd = Processingst.pop();
                    if (nd != null) {
                        ll.add(nd.val);
                        if (nd.left != null)
                            Node_Stack.add(nd.left);

                        if (nd.right != null)
                            Node_Stack.add(nd.right);
                    }
                }
                reverse = false;
            } else {
                while (Node_Stack.size() > 0) {
                    TreeNode nd = Node_Stack.pop();
                    if (nd != null) {
                        ll.add(nd.val);
                        if (nd.right != null)
                            Processingst.add(nd.right);
                        if (nd.left != null)
                            Processingst.add(nd.left);

                    }
                }
                reverse = true;
            }
            res.add(ll);
        }

        return res;
    }

    public static List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        Map<Double, Integer> st = new HashMap<>();
        if (root == null)
            return res;

        traverse(root, target, pq, st);

        while (pq.size() != 0 && k > 0) {
            double tv = pq.poll();
            res.add(st.get(tv));
            k--;
        }

        return res;
    }

    private static void traverse(TreeNode root, double target, PriorityQueue<Double> pq, Map<Double, Integer> st) {
        if (root == null)
            return;

        double diff = Math.abs(root.val - target);
        pq.add(diff);
        st.put(diff, root.val);

        if (root.left != null)
            traverse(root.left, target, pq, st);

        if (root.right != null)
            traverse(root.right, target, pq, st);

        return;

    }
}