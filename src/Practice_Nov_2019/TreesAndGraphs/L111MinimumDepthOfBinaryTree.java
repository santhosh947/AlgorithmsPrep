package Practice_Nov_2019.TreesAndGraphs;

class L111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode lleaf1 = new TreeNode(9);
        TreeNode rleaf1 = new TreeNode(20);

        TreeNode rleaf2 = new TreeNode(5);
        TreeNode lleaf2 = new TreeNode(4);

        TreeNode root = new TreeNode(1);

        rleaf1.right = rleaf2;
        rleaf1.left = lleaf2;

        root.left = lleaf1;
        root.right = rleaf1;

        System.out.println(minDepth(root));
    }

    //static int res=0;
    public static int minDepth(TreeNode root) {
        if(root==null)
            return 0;

       // res++;
        if(root.left == null || root.right == null)
            return 1;
        
       return rec_depth(root, 0);
    }

    public static int rec_depth(TreeNode r, int c)
    {
        if(r==null)
            return c;
        
        c++;
        return Math.min(rec_depth(r.left, c), rec_depth(r.right, c));

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