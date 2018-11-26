package prac;


public class BSTDistance {
	public static class treeNode {
		int data;
		treeNode left;
		treeNode right;

		public treeNode(int d) {
			this.data = d;
			left = null;
			right = null;

		}
	}

	private static treeNode root = null;

	public static void main(String[] args) {
		int[] arr = { 25, 10, 15, 20, 5, 30, 35, 45 };
		for (int i = 0; i < arr.length; i++) {
			if (root == null) {
				root = new treeNode(arr[i]);
			} else {
				insertNode(arr[i], root);
			}
		}
		int i=5,j=45;
		int dist = distFromRoot(i) + distFromRoot(j) - 2
				* distFromRoot(findLCA(i,j, root));
		System.out.println(dist);
		
		System.out.println("complete");
	}

	private static int findLCA(int i, int j, treeNode nd) {
		if(nd.data == i || nd.data==j)
			return nd.data;
		else if((nd.data>i && nd.data<j)||(nd.data<i && nd.data>j))
			return nd.data;
		else if(nd.data>i && nd.data>j)
			return findLCA(i, j, nd.left);
		else if(nd.data<i && nd.data<j)
			return findLCA(i, j, nd.right);
		return nd.data;
	}

	private static int distFromRoot(int i) {
		int dist = 0;
		treeNode temp = root;
		while (temp != null && temp.data != i) {
			if (temp.data > i) {
				temp = temp.left;

			} else {
				temp = temp.right;
			}
			dist++;
		}
		if (temp == null)
			dist = 0;
		return dist;
	}

	

	private static treeNode insertNode(int i, treeNode tN) {
		if (tN == null) {
			tN = new treeNode(i);
			return tN;
		} else if (tN.data > i) {
			tN.left = insertNode(i, tN.left);

		} else if (tN.data < i) {
			tN.right = insertNode(i, tN.right);
		}
		return tN;
	}

}
