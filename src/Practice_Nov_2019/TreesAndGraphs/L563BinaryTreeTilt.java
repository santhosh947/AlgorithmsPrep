package Practice_Nov_2019.TreesAndGraphs;

public class L563BinaryTreeTilt {
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

        int a=4;
        double b = 3.74567;
        double res = Math.abs(Double.valueOf(a)-b);

        System.out.println(res);

        TreeNode r = new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);

        r.left=l1;
        r.right=r1;
        System.out.println(findTilt(r));
    }

    private static int res;
    public static int findTilt(TreeNode r) {
        res = 0;
        if(r == null)
            return res;

        findRecTilt(r);
        return res;
        
    }

    private static int findRecTilt(TreeNode r) {
        if(r==null)
            return 0;

        int leftSum = findRecTilt(r.left);
        int rightSum = findRecTilt(r.right);
        res+= Math.abs(leftSum-rightSum);


        return r.val+leftSum+rightSum;
    }
}