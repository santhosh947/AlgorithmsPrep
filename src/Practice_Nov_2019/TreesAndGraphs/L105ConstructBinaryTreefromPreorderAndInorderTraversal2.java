package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class L105ConstructBinaryTreefromPreorderAndInorderTraversal2 {
  public static void main(String[] args) {
    int[] pre = { 3, 9, 20, 15, 7 };
    int[] in = { 9, 3, 15, 20, 7 };
    TreeNode r = buildTree(pre, in);
    System.out.println(r.val);
  }

  static int pre_idx = 0;
  static int[] preorder;
  static int[] inorder;
  static HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public static TreeNode helper(int in_left, int in_right) {
    // if there is no elements to construct subtrees
    if (in_left == in_right)
      return null;

    // pick up pre_idx element as a root
    int root_val = preorder[pre_idx];
    TreeNode root = new TreeNode(root_val);

    // root splits inorder list
    // into left and right subtrees
    int index = idx_map.get(root_val);

    // recursion
    pre_idx++;
    // build left subtree
    root.left = helper(in_left, index);
    // build right subtree
    root.right = helper(index + 1, in_right);
    return root;
  }

  public static TreeNode buildTree(int[] pre, int[] in) {
    preorder = pre;
    inorder = in;

    // build a hashmap value -> its index
    int idx = 0;
    for (Integer val : inorder)
      idx_map.put(val, idx++);
    return helper(0, inorder.length);
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