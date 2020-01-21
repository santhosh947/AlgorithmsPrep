package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L105ConstructBinaryTreefromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode r = buildTree(pre, in);
        System.out.println(r.val);
    }

    private static TreeNode ans;
    private static Map<Integer, Integer> pre_pos;
    private static Map<Integer, Integer> in_pos;
    private static int id;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        ans = null;
        id = 0;
        pre_pos = new HashMap();
        in_pos = new HashMap();
        if (preorder == null || inorder == null || preorder.length == 0)
            return root;

        if (preorder.length == 1) {
            root = new TreeNode(preorder[0]);
            return root;
        }

        // for (int i = 0; i < preorder.length; i++) {
        //     pre_pos.put(preorder[i], i);
        // }

        for (int i = 0; i < inorder.length; ) {
            in_pos.put(inorder[i], i++);
        }

        // root= new TreeNode(preorder[0]);
        // ans = root;
        return buildTree_rec(preorder, inorder, 0, preorder.length);

    }

    private static TreeNode buildTree_rec(int[] pre, int[] in, int l, int r) {
        if (l == r)
            return null;

        TreeNode t = new TreeNode(pre[id]);
        int index = in_pos.get(pre[id]);
        id += 1;
        t.left = buildTree_rec(pre, in, l, index);
        t.right = buildTree_rec(pre, in, index + 1, r);

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