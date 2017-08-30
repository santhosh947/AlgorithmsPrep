package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
	static Node newRoot;
	static Stack stk = new Stack();

	public static void main(String args[]) {
		Node lleaf3 = new Node(5, null, null);
		Node lleaf1 = new Node(1, null, null);

		Node rleaf4 = new Node(7, null, null);

		Node rleaf1 = new Node(6, lleaf3, rleaf4);
		Node rleaf2 = new Node(3, null, null);

		Node lleaf2 = new Node(2, lleaf1, rleaf2);
		Node root = new Node(4, lleaf2, rleaf1);

		/*System.out.println(checkBST(root));
		System.out.print("Inorder ");
		printInorder(root);
		System.out.println();
		System.out.print("PostOrder ");
		printPostOrder(root);
		System.out.println();
		System.out.print("PreOrder ");
		printPreOrder(root);
*/
		String preorder = "4 2 1 3 6 5 7";
		String inOrder = "1 2 3 4 5 6 7";

		Node temp = newRoot;
		String[] preStr = preorder.split(" ");
		List Pre = new ArrayList<Integer>();
		int i = 0;
		for (String s : preStr) {
			Pre.add(Integer.parseInt(s));
		}

		String[] inStr = inOrder.split(" ");
		List In = new ArrayList<Integer>();
		i = 0;
		for (String s : inStr) {
			In.add(Integer.parseInt(s));
		}

		Node newRoot = buildTree(Pre, In);

//		System.out.println("**************");
//		System.out.print("Inorder ");
//		printInorder(newRoot);
//		System.out.println();
//		System.out.print("PostOrder ");
//		printPostOrder(newRoot);
//		System.out.println();
//		System.out.print("PreOrder ");
//		printPreOrder(newRoot);
//		System.out.println();
//		System.out.println("************************************");
//		System.out.print("PreOrder ");
//		printPreOrder(root);
//		System.out.println();
//		stk.push(root);
//		preOrderTraverselNonRecurrsive(root);
//
//		System.out.println("\nInorder ");
//		printInorder(root);
//		System.out.println();
//		stk = new Stack<>();
//		stk.push(root);
//		inOrderTraverselNonRecurrsive(root);
		
		
		System.out.println(longestConsecutive(root));
	}
	
	static List<Integer> treeval = new ArrayList<>();
	public static int longestConsecutive(Node nd)
	{
		storeInorder(nd);
		treeval.clear();
		treeval.add(1);
		treeval.add(2);
		treeval.add(3);
		treeval.add(4);
		return findLongestSeq();
		
	}

	private static int findLongestSeq() {
		int diff=-1;
		int counter=1;
		if(treeval.get(0)>treeval.get(1))
			diff=1;
		int len=treeval.size();
		for(int i=0;i<len-1;i++)			
		{
			if(treeval.get(i)-treeval.get(i+1)==diff)
				counter++;
			else
				break;
		}
		return counter;
	}

	private static void inOrderTraverselNonRecurrsive(Node nd) {
		if (nd == null)
			return;

		Node curr = nd;
		Node fwd;
		if (curr.left != null) {
			stk.push(curr.left);
			fwd = curr.left;
		} else {
			Node temp = nd;
			while (temp.right == null && stk.size() > 0) {
				temp = (Node) stk.pop();
				System.out.print(temp.data + " ");
			}
			fwd = temp.right;
			if (fwd != null)
				stk.push(fwd);
		}
		// System.out.println(curr.data);
		inOrderTraverselNonRecurrsive(fwd);
	}

	public static void preOrderTraverselNonRecurrsive(Node nd) {
		if (nd == null)
			return;
		Node curr = nd;
		Node fwd;
		if (curr.left != null) {
			stk.push(curr.left);
			fwd = curr.left;
		} else {
			Node temp = (Node) stk.pop();
			while (temp.right == null && stk.size() > 0) {
				temp = (Node) stk.pop();
			}
			fwd = temp.right;
			if (fwd != null)
				stk.push(fwd);
		}
		System.out.print(curr.data + " ");
		preOrderTraverselNonRecurrsive(fwd);
	}

	/*
	 * private static boolean checkBST(Node root) { if(root!=null &&
	 * checkLeftSubTree(root.left) && checkLeftSubTree(root.right)) {
	 * checkBST(root.left); checkBST(root.right); return true; } else return
	 * false; }
	 * 
	 * private static boolean checkLeftSubTree(Node nd) { if(nd!=null) {
	 * if(nd.data > nd.left.data && nd.data < nd.right.data) { return true; } }
	 * return false; }
	 */

	private static Node buildTree(List preorder, List inOrder) {
		if (preorder.size() == 0 || inOrder.size() == 0) {
			return null;
		}
		int temp = (int) preorder.get(0);
		int i = 1, j = 0;
		List leftIn = new ArrayList<Integer>();
		List leftPre = new ArrayList<Integer>();
		List rightIn = new ArrayList<Integer>();
		List rightPre = new ArrayList<Integer>();

		boolean isRootFound = false;
		while (i < preorder.size() && j < inOrder.size()) {
			if (temp == (int) inOrder.get(j) && !isRootFound) {
				isRootFound = true;
				j++;
			} else {
				if (!isRootFound) {
					leftIn.add(inOrder.get(j));
					leftPre.add(preorder.get(i));
				} else {
					rightIn.add(inOrder.get(j));
					rightPre.add(preorder.get(i));
				}
				i++;
				j++;
			}
		}
		Node orgNode = new Node(temp, buildTree(leftPre, leftIn), buildTree(
				rightPre, rightIn));
		return orgNode;
	}

	private static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	private static void storeInorder(Node root) {
		if (root == null)
			return;
		storeInorder(root.left);
		treeval.add(root.data);
		storeInorder(root.right);
	}

	private static void printPostOrder(Node root) {
		if (root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");
	}

	private static void printPreOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	static boolean checkBST(Node root) {
		if (root != null) {
			if (root.left != null) {
				if (root.data <= root.left.data) {
					return false;
				}
				checkBST(root.left);
			}
			if (root.right != null) {
				if (root.data >= root.right.data) {
					return false;
				}
				checkBST(root.right);
			}
		}
		return true;
	}

	static boolean checkBST1(Node root) {
		if (root == null)
			return true;
		return (root.data <= root.left.data && root.data >= root.right.data);
	}
}
