package prac;

public class SymmtericTree {
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(4);
		TreeNode lr1 = new TreeNode(2);
		lr1.left = l1;
		lr1.right = r1;

		TreeNode l2 = new TreeNode(4);
		TreeNode r2 = new TreeNode(3);
		TreeNode lr2 = new TreeNode(2);
		lr2.left = l2;
		lr2.right = r2;

		TreeNode root = new TreeNode(1);
		root.left = lr1;
		root.right = lr2;
		
		TreeNode ll1=new TreeNode(2);
		
		TreeNode llR1=new TreeNode(3);
		ll1.right=llR1;
		
		TreeNode llr1=new TreeNode(2);
		TreeNode lrr=new TreeNode(3);
		llr1.right=lrr;
		
		/*root.left = ll1;
		root.right = llr1;
*/
		System.out.println(isSymmetric(root));

	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		TreeNode hd = root;
		TreeNode left = hd.left;
		TreeNode right = hd.right;
		return checkSym(left, right);
	}

	public static boolean checkSym(TreeNode l, TreeNode r) {
		if(l==null && r!=null)
            return false;
        if(r==null && l!=null)
            return false;
		if (l == null || r == null)
			return true;

		if (l.val != r.val)
			return false;
		else {
			if(!checkSym(l.left, r.right))
				return false;
			if(!checkSym(l.right, r.left))
				return false;
		}
		return true;
	}
}
