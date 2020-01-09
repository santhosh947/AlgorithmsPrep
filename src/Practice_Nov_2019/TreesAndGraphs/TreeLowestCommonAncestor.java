package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class TreeLowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode rl1 = new TreeNode(5);
        TreeNode rr1 = new TreeNode(1);

        r.left = rl1;
        r.right = rr1;

        TreeNode rr2 = new TreeNode(6);
        TreeNode rr3 = new TreeNode(2);

        rl1.right = rr2;
        rl1.left = rr3;

        TreeNode rr4 = new TreeNode(7);
        TreeNode rl4 = new TreeNode(4);

        rr3.left = rl4;
        rr3.right = rr4;

        TreeNode rr5 = new TreeNode(0);
        TreeNode rl5 = new TreeNode(8);

        rr1.left = rl5;
        rr1.right = rr5;

        TreeNode res = lowestCommonAncestor(r, rl1, rl4);

        System.out.println(res.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
}