package Practice_Nov_2019.TreesAndGraphs;

class L104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        
    }

    public static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return findDepth(root, 0);
    }

    private static int findDepth(TreeNode root, int i) {
        if(root==null)
            return i;
        
        return Math.max(findDepth(root.left, i+1), findDepth(root.right, i+1));
    }
}