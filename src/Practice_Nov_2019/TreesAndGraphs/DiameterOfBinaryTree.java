package Practice_Nov_2019.TreesAndGraphs;

class DiameterOfBinaryTree
{
    public static void main(String[] args) {
        TreeNode lleaf1 = new TreeNode(2);
        TreeNode rleaf1 = new TreeNode(3);
    
        
        TreeNode rleaf2 = new TreeNode(5);
        TreeNode lleaf2 = new TreeNode(4);

        TreeNode root = new TreeNode(1);
    
            lleaf1.right = rleaf2;
            lleaf1.left = lleaf2;
        
        root.left = lleaf1;
        root.right = rleaf1;
          
         System.out.println(diameterOfBinaryTree(root));
    }

    static int max =0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        max = 1;
        depth(root);
        return max-1;
    }

    public static int depth(TreeNode r)
    {
        if(r==null)
            return 0;
        
        int left = depth(r.left);
        int right = depth(r.right);

        max = Math.max(max, left+right+1);

        return (Math.max(left, right) + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v)
        {
            val = v;
        }
    }

}