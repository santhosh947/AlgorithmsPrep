package Practice_Nov_2019.TreesAndGraphs;

class L108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] a = {-10,-3,0,5,9};
        TreeNode r = sortedArrayToBST(a);
        System.out.println(r.val);
    }

    //private static TreeNode root = null;

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        
    //     if(nums.length==1)
    //     {
    //         root = new TreeNode(nums[0]);
    //     }
    //    // root = new TreeNode(nums[nums.length/2]);

        return buildTree(nums,0, nums.length-1);

    }

    private static TreeNode buildTree(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }
        int p = (l+r)/2;
                
        TreeNode nd = new TreeNode(nums[p]);

        nd.left = buildTree(nums, l,p-1);
        nd.right = buildTree(nums, p+1, r);

        return nd;
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