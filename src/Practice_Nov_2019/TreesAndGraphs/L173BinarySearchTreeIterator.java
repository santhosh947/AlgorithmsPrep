package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L173BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(7);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(15);

        TreeNode l2 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);

        r.left = l1;
        r.right = r1;

        r1.left = l2;
        r1.right = r2;

        BSTIterator it = new BSTIterator(r);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    private static class BSTIterator {
        static Stack<TreeNode> st;
        TreeNode r;

        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            r = root;
            if (r != null) {
                st.add(r);
                Traverse(r.left);
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode t = st.pop();
            if (t.right != null)
                Traverse(t.right);
            return t.val;

        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (st.empty())
                return false;

            return true;

        }

        private static TreeNode Traverse(TreeNode rr) {
            if (rr == null)
                return null;

            st.add(rr);
            if (rr.left == null && rr.right == null)
                return rr;
            TreeNode l = Traverse(rr.left);
            // TreeNode r = Traverse(rr.right);
            if (l == null)// )
                return rr;
            return rr;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}