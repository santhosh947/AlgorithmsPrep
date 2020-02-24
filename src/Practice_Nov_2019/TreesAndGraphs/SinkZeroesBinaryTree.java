package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class SinkZeroesBinaryTree {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(0);

        r.left=l1;
        r.right=r1;

        TreeNode l2 = new TreeNode(0);
        TreeNode r2 = new TreeNode(2);

        r1.right=r2;
        r1.left=l2;

               
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);

        l2.left=l3;
        l2.right=r3;

        tr_trav_sink_zeros n = new tr_trav_sink_zeros();

        TreeNode res = n.sink(r);
        System.out.println(res.val);

    }
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    private static class tr_trav_sink_zeros {
        
        private static int num_zero;
        public TreeNode sink(TreeNode root) {
            num_zero=0;
            explore(root, new Stack<Integer>());
            return root;
        }
    
        private void explore(TreeNode c, Stack<Integer> st) {
            if (c == null) {
                return;
            }
            if(c.val==0)
            {
                num_zero=num_zero+1;
            }
            else {
                st.add(c.val);
            }
        
    
            explore(c.left, st);
            explore(c.right, st);
            if(num_zero>0)
            {
                num_zero=num_zero-1;
                c.val=0;
            }
            else {
                if(!st.isEmpty())
                    c.val=(int)st.pop();
            }    
            
        }
    }
}