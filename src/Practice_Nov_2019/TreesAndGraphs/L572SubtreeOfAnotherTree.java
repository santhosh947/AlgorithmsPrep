package Practice_Nov_2019.TreesAndGraphs;

class L572SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode ri1 = new TreeNode(5);
        TreeNode l2 = new TreeNode(1);
        TreeNode ri2 = new TreeNode(2);

        r1.left=l1;
        r1.right = ri1;
        l1.left=l2;
        l1.right=ri2;

        TreeNode ll1 = new TreeNode(4);
        TreeNode ll2 = new TreeNode(1);
        TreeNode rr2 = new TreeNode(2);

        ll1.left=ll2;
        ll1.right = rr2;

        System.out.println(isSubtree(r1,ll1));


    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public static boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public static boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}