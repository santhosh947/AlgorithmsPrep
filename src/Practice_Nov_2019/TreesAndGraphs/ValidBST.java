package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int val) {
        this.val = val;
    }
}

class ValidBST {
    public static void main(String[] args) {
        TreeNode2 lleaf1 = new TreeNode2(1);
        TreeNode2 rleaf1 = new TreeNode2(6);

        TreeNode2 lleaf2 = new TreeNode2(3);

        TreeNode2 rleaf2 = new TreeNode2(7);
        rleaf1.left = lleaf2;
        rleaf1.right = rleaf2;

        // TreeNode2 rleaf2 = new TreeNode2(10);

        // TreeNode2 lleaf2 = new TreeNode2(2);
        // lleaf2.left = lleaf1;
        // lleaf2.right = rleaf2;

        TreeNode2 root = new TreeNode2(5);
        root.left = lleaf1;
        root.right = rleaf1;

        System.out.println(isValidBST_st(root));

        // LinkedList ll = new LinkedList<>();
        // inOrderTraversal(root, ll);
        // System.out.println();
        // LinkedList t = ll;
        // while(!t.isEmpty())
        // {
        // System.out.print(t.poll() +",");
        // }
    }

    public static boolean inOrderTraversal(TreeNode2 r, Stack l, int dec) {
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

    public static boolean isValidBST22(TreeNode2 root) {
        Stack ll = new Stack<>();

        return inOrderTraversal(root, ll, 1);
    }

    public static boolean isValidBST(TreeNode2 root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean isValidBST2(TreeNode2 root, long minVal, long maxVal) {
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

    public static boolean isValidBST_st (TreeNode2 rt){
        Stack<TreeNode2> stack = new Stack<TreeNode2> ();
        TreeNode2 cur = rt ;
        TreeNode2 pre = null ;		   
        while (!stack.isEmpty() || cur != null) {			   
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {				   
                TreeNode2 p = stack.pop() ;
                if (pre != null && p.val <= pre.val) {					   
                    return false ;
                }				   
                pre = p ;					   
                cur = p.right ;
            }
        }
        return true ; 
    }
}