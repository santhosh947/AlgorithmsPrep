package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class FlattenBinaryTree {
    public static void main(String[] args) {
        TreeNode lleaf1 = new TreeNode(2);
        TreeNode rleaf1 = new TreeNode(5);

        TreeNode lleaf2 = new TreeNode(3);
        TreeNode rleaf12 = new TreeNode(4);

        TreeNode rleaf2 = new TreeNode(6);

        TreeNode root = new TreeNode(1);

        lleaf1.left = lleaf2;
        lleaf1.right = rleaf12;

        rleaf1.right = rleaf2;

        root.left = lleaf1;
        root.right = rleaf1;


        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(2);
        TreeNode r = new TreeNode(1);

        r1.left = l1;
        r.right=r1;

        preOrderTraversal(root);

        flatten(root);
        System.out.println();

        preOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode r) {
        if (r == null)
            return;
        preOrderTraversal(r.left);
        preOrderTraversal(r.right);
        System.out.print(r.val + ",");

    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> qu = new LinkedList();
        Stack<TreeNode> st = new Stack();

        qu.add(root.left);
        st.add(root.right);

        TreeNode t_ptr = root;
        TreeNode left_travsel = null;


        while (!qu.isEmpty() || !st.isEmpty() || left_travsel!=null){
            // process Left tree
            if (!qu.isEmpty())
                left_travsel = qu.poll();
            while (left_travsel != null) {
               // TreeNode temp = t_ptr.right;
                TreeNode temp_left_traversal = left_travsel.left;
                st.add(left_travsel.right);
                left_travsel.left = null;
                if(t_ptr.right != left_travsel)
                {
                    left_travsel.right = t_ptr.right;
                }
                t_ptr.right = left_travsel;
                t_ptr.left=null;
                t_ptr = t_ptr.right;
                left_travsel = temp_left_traversal;
            }
            //prcoss right
            if(qu.isEmpty() && !st.isEmpty())
            {
                left_travsel=st.pop();
            }
        }

        // while (t_ptr != null) {
        // while (!st.isEmpty() || firstTime) {
        // firstTime = false;
        // if(!st.isEmpty())
        // left_travsel = st.pop();

        // while (left_travsel != null) {
        // TreeNode temp = t_ptr.right;
        // TreeNode temp_left_traversal = left_travsel.left;
        // st.add(left_travsel.right);
        // left_travsel.left = null;
        // left_travsel.right = t_ptr.right;
        // t_ptr.right = left_travsel;
        // t_ptr = t_ptr.right;
        // left_travsel = temp_left_traversal;
        // }
        // }

        // }

    }

    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int v)
        {
            val=v;
        }
    }
}