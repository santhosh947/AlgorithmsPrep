package Old_files;
import java.util.Stack;

class TreeNode
{
	int val;
TreeNode left;
TreeNode right;
public TreeNode(int val)
{
	this.val=val;
}
}
public class ValidBST {
	
	public static boolean isValidBST (TreeNode root){
		   Stack<TreeNode> stack = new Stack<TreeNode> ();
		   TreeNode cur = root ;
		   TreeNode pre = null ;		   
		   while (!stack.isEmpty() || cur != null) {			   
			   if (cur != null) {
				   stack.push(cur);
				   cur = cur.left ;
			   } else {				   
				   TreeNode p = stack.pop() ;
				   if (pre != null && p.val <= pre.val) {					   
					   return false ;
				   }				   
				   pre = p ;					   
				   cur = p.right ;
			   }
		   }
		   return true ; 
	   }
}
