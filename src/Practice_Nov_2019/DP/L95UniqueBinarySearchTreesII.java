package Practice_Nov_2019.DP;

import java.util.*;

class L95UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(2);
    }

    public static LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
      }

    private static List<TreeNode> res;

    public static List<TreeNode> generateTrees2(int n) {
        res = new ArrayList();
        if (n == 0)
            return null;

        if (n == 1) {
            res.add(new TreeNode(1));
        }
        if (n > 1) {
            BuildTree(n, 1, n, null, null);
        }
        return res;
    }

    private static TreeNode BuildTree(int n, int start, int end, TreeNode curr, TreeNode root) {
        if (end > n || start < 0 || n <= 0 || end < 0 || start > end) {
            //if(root!=null) res.add(root);
            return null;
        }
        TreeNode t =null;
        for (int i = start; i <= end; i++) {
            int left_count = i - start;
            int right_count = end - i;
            t = new TreeNode(i);
            if(root==null)
                root = t;
            TreeNode left = BuildTree(left_count, start, left_count - 1, t, root);
            TreeNode right = BuildTree(right_count, right_count + 1, end,t , root);
            t.left = left;
            t.right = right;
        }
        return t;

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