package prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTLinearOrder {
	public static class treeNode{
		int data;
		treeNode left;
		treeNode right;
		public treeNode(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	public static treeNode BTRoot = null;
	
	public static treeNode root=null;
	public static void main(String[] args) {
		/* 			100
        	  75	         125
  		 70       80    120         130 
        69 71   79 81 119  121    129  131
		*/
		int[] arr  = {100,75,125,70,80,120,130,69,71,79,81,119,121,129,131};
		for(int i=0;i<arr.length;i++)
		{
			if(root==null)
				root = new treeNode(arr[i]);
			else
				insert(root,arr[i]);
		}
		
		queue.add(root);
		printInorder(queue.poll());
		
		System.out.println("*****************************");
		CreateBinaryTree();

		queue.clear();
		queue.add(BTRoot);
		printInorder(queue.poll());
		System.out.println("END");
	}
	private static void CreateBinaryTree() {
		BTRoot = new treeNode(1);
		BTRoot.left = new treeNode(2);
		BTRoot.right = new treeNode(3);
		BTRoot.left.left=new treeNode(4);
		BTRoot.right.left=new treeNode(6);
	}
	static Queue<treeNode> queue  = new LinkedList<treeNode>();

	private static void printInorder(treeNode root2) {
		
		if(queue.isEmpty() && root2==null)
			return;
		
		if(root2!=null)
		{
			System.out.print(root2.data + " ");
		
			queue.add(root2.left);
			queue.add(root2.right);
			printInorder(queue.poll());
		}
	}
	private static treeNode insert(treeNode ro, int data) {
		treeNode root2=ro;
		// TODO Auto-generated method stub
		if(root2==null)
		{
			root2=new treeNode(data);
			return root2;
		}
		else
		{
			if(data>root2.data)
			{
				ro.right=insert(root2.right, data);
			}
			else if(data<root2.data)
			{
				ro.left=insert(root2.left,data);
			}
		}
		return root2;
	}
}
