package prac;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class MyNode {
	TreeNode node;
	MyNode parent;
	boolean visited;
	List<TreeNode> result = new ArrayList<TreeNode>();

	public MyNode(TreeNode node, MyNode parent) {
		this.node = node;
		this.parent = parent;
	}
}

public class LowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode ll1=new TreeNode(6);
		TreeNode l1=new TreeNode(5);
		l1.left=ll1;
		TreeNode lr1 = new TreeNode(8);
		TreeNode r1=new TreeNode(1);
		r1.left=lr1;
		TreeNode root= new TreeNode(3);
		root.left=l1;
		root.right=r1;
		
		TreeNode res=lowestCommonAncestor(root, ll1, lr1);
		System.out.println(res.val);
		res=LCARecurrsion(root, ll1, lr1);
		System.out.println(res.val);
	}
	
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        
        if((root.val>p.val && root.val<q.val) || (root.val<p.val && root.val>q.val))
            return root;
        
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);
    }
	
	public static TreeNode LCARecurrsion(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root==null || root == p || root ==q)
			return root;
		TreeNode left=LCARecurrsion(root.left, p, q);
		TreeNode right = LCARecurrsion(root.right, p, q);
		return (left==null) ? right : (right==null) ? left : root;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
