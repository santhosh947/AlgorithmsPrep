package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class ValidBST {
    public static void main(String[] args) {
        TreeNode lleaf1 = new TreeNode(1);
        TreeNode rleaf1 = new TreeNode(6);

        TreeNode lleaf2 = new TreeNode(3);

        TreeNode rleaf2 = new TreeNode(7);
        rleaf1.left = lleaf2;
        rleaf1.right = rleaf2;

        // TreeNode rleaf2 = new TreeNode(10);

        // TreeNode lleaf2 = new TreeNode(2);
        // lleaf2.left = lleaf1;
        // lleaf2.right = rleaf2;

        TreeNode root = new TreeNode(5);
        root.left = lleaf1;
        root.right = rleaf1;

        System.out.println(isValidBST(root));

        // LinkedList ll = new LinkedList<>();
        // inOrderTraversal(root, ll);
        // System.out.println();
        // LinkedList t = ll;
        // while(!t.isEmpty())
        // {
        // System.out.print(t.poll() +",");
        // }
    }

    public static boolean inOrderTraversal(TreeNode r, Stack l, int dec) {
        if (r == null || dec == 0)
            return false;

        inOrderTraversal(r.left, l, dec);
        System.out.print(r.val + ",");
        if (!l.isEmpty() && (int) l.peek() > r.val) {
            dec = 0;
            return false;
        } else
            l.add(r.val);

        inOrderTraversal(r.right, l, dec);

        return true;
    }

    public static boolean isValidBST22(TreeNode root) {
        Stack ll = new Stack<>();

        return inOrderTraversal(root, ll, 1);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean isValidBST2(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) 
        	return false;
        
        if(isValidBST2(root.left, minVal, root.val) && isValidBST2(root.right, root.val, maxVal))
        {
        	return true;
        }
        else
        	return false;
    }
}