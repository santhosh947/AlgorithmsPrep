package Practice_Nov_2019.Array;

class L270ClosestBinarySearchTreeValue {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val=x;
        }
    }
    public static void main(String[] args) {
        TreeNode r= new TreeNode(1500000000);
        TreeNode l = new TreeNode(1400000000);
        r.left = l;
        double target = -1500000000.0;

        System.out.println(closestValue(r, target));
        System.out.println(closestValue2(r, target));

    }

    private static int res;
    private static double globalDiff;
    public static int closestValue(TreeNode root, double target) {
        res =root.val;
               
        BinarySearch(root, target);
        return res;
    }
    
    public static void BinarySearch(TreeNode root, double target) {
        if(root == null)
            return;
        
        double diff = root.val - target;
        diff = Math.abs(diff);
        if(diff<Math.abs(target-res))
        {
            res = root.val;
            globalDiff= diff;
        }
        if(root.val<target)
        {
            BinarySearch(root.right, target);
        }
        else if(root.val>target)
        {
            BinarySearch(root.left, target);
        }
        
           // res= root.val;
         
        return;
    }

    public static int closestValue2(TreeNode root, double target) {
        int ret = root.val;   
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }      
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }
}