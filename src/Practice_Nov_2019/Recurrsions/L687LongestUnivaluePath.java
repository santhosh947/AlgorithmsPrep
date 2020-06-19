package Practice_Nov_2019.Recurrsions;

public class L687LongestUnivaluePath {
    public static class TreeNode {
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
        
    }

    private static int mx;
    public static int longestUnivaluePath(TreeNode root) {
        //int res =0;

        if(root == null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        
        mx=0;

        traverse(root,1);

        return mx;
        
    }

    private static void traverse(TreeNode r, int curr_ct)
    {
        if(curr_ct>mx)
            mx=curr_ct;

        if(r==null)
            return;

        TreeNode l_child = r.left;
        TreeNode r_child = r.right;

        if(l_child.val== r.val)
        {
            curr_ct++;
            traverse(l_child,curr_ct);
        }
        else if(r_child.val == r.val)
        {
            curr_ct++;
            traverse(r_child,curr_ct);
        }
        else {
            traverse(l_child, 0);
            traverse(r_child,0);
        }
    }
    
}