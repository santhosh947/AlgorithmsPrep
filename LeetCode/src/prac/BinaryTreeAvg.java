package prac;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeAvg {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode d1 = new TreeNode(9);
		TreeNode d2 = new TreeNode(20);
		TreeNode d3 = new TreeNode(15);
		TreeNode d4 = new TreeNode(7);
		
	//	root.left=d1;
		//root.right=d2;
		//d2.left=d3;
		//d2.right=d4;
		
		List<Double> res = averageOfLevels(root);
		for(Double d: res)
		{
			System.out.println(d);
		}
	}
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> op = new ArrayList<>();
		if(root!=null)
			op.add((double) root.val);
		List<TreeNode> childs=new ArrayList<>();
		if(root.left!=null)
			childs.add(root.left);
		if(root.right!=null)
			childs.add(root.right);
		
		findAvg(childs,op);
		return op;

	}

	private static void findAvg(List<TreeNode> childs,List<Double> op) {
		if(childs.size()==0)
			return;
		double res=0.0;
		int cnt=0;
		List<TreeNode> newChilds=new ArrayList<>();
		for(int i=0;i<childs.size();i++)
		{
			if(childs.get(i)!=null)
			{
				res+=childs.get(i).val;
				cnt++;
				if(childs.get(i).left!=null)
					newChilds.add(childs.get(i).left);
				if(childs.get(i).right!=null)
					newChilds.add(childs.get(i).right);
			}			
		}
		op.add(res/cnt);
		findAvg(newChilds, op);
	}
}
