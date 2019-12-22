package Practice_Nov_2019.TreesAndGraphs;

class TreeMaxPathSum {
    public static void main(String[] args) {

        TreeNode lleaf1 = new TreeNode(2);
        TreeNode rleaf1 = new TreeNode(3);
     
        TreeNode root = new TreeNode(1);

        root.left = lleaf1;
        root.right = rleaf1;

       System.out.println(maxPathSum(root));

    }


    static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    // helper returns the max branch 
    // plus current node's value
    static int helper(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        max = Math.max(max, root.val + left + right);
        
        return root.val + Math.max(left, right);
    }
    
}