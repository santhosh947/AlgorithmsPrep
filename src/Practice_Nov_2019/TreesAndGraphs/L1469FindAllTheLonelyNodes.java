package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

public class L1469FindAllTheLonelyNodes {

    private static class TreeNode {
          int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
    }
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);

        TreeNode r2 = new TreeNode(4);

        r.left=l1;
        r.right=r1;

        l1.right=r2;

        List<Integer> res = getLonelyNodes(r);

        for(int i: res)
        {
            System.out.println(i);
        }
    }
    //private 

    public static List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList();
        

        if((root.left==null && root.right!=null))
        {
            res.add(root.right.val);  
            findLonlyNodes(root.right, res);

        } 
        else if (root.left!=null && root.right==null)
        {
            res.add(root.left.val);
            findLonlyNodes(root.left, res);

        }
        else if(root.left!=null && root.right!=null)
        {
            findLonlyNodes(root.right, res);

            findLonlyNodes(root.left, res);

        }

        return res;
        
    }

    private static void findLonlyNodes(TreeNode root, List<Integer> res) {
        if((root.left==null && root.right!=null))
        {
            res.add(root.right.val);  
            findLonlyNodes(root.right, res);

        } 
        else if (root.left!=null && root.right==null)
        {
            res.add(root.left.val);
            findLonlyNodes(root.left, res);

        }
        else if(root.left!=null && root.right!=null)
        {
            findLonlyNodes(root.right, res);

            findLonlyNodes(root.left, res);

        }

        return;
    }
}