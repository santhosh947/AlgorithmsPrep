package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;
class L226InvertBinaryTree {
    public static void main(String[] args) {
        
    }
    public static TreeNode invertTree(TreeNode root) {
        //4 , 2 , 7, 1,3,6,9
        // 4, 7,2,3,1,,9,6
        Stack<TreeNode> st = new Stack();
        st.add(root);

        TreeNode new_r = new TreeNode(root.val);
        TreeNode temp = new_r;

        while(!st.isEmpty())
        {
            List<TreeNode> l = new ArrayList();
            TreeNode r = st.pop();
            l.add(r.left);
            l.add(r.right);

            st.add(r.left);
            st.add(r.right);
            
        }

        return new_r;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) 
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) 
                queue.add(current.left);
            if (current.right != null) 
                queue.add(current.right);
        }
        return root;
    }
}