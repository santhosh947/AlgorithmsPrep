package Old_files;

public class BuildBSTAndFindDistanceBetweenTwoNodes {
	
	public static void main(String[] args) {
		int[] values = {5,3,6,1,2,4};
		System.out.println(bstDistance(values,6,21,41));
		System.out.println(bstDistance(values,6,2,4));

	}

	public static Node findNode(Node r, int n) {
		Node temp = r;

		while (temp != null) {
			if (temp.val == n)
				return temp;
			if (n > temp.val) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return null;

	}

	public static int distance(Node root, Node node1, Node node2) {
		if (root == null || node1 == node2)
			return 0;
		if (root.val >= node1.val && root.val <= node2.val)
			return distance(root, node1) + distance(root, node2);
		else if (root.val < node1.val && root.val < node2.val)
			return distance(root.right, node1, node2);
		else {
			return distance(root.left, node1, node2);
		}
	}

	public static int distance(Node root, Node node1) {
		if (root == node1)
			return 0;
		if (root.val < node1.val) {
			return 1 + distance(root.right, node1);
		} else {
			return 1 + distance(root.left, node1);
		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int bstDistance(int[] values, int n, int node1, int node2) {

		Node root = buildBST(values);
		Node n1 = findNode(root, node1);
		Node n2 = findNode(root, node2);

		if (n1 == null || n2 == null) {
			return -1;
		}
		int dist = distance(root, n1, n2);
		return dist;
	}

	private static Node buildBST(int[] values) {
		Node root = null;
		Node curr = root;
		Node prev = root;

		for (int i = 0; i < values.length; i++) {
			curr = root;
			prev = root;
			Node n = new Node(values[i]);

			if (root == null) {
				root = n;
			} else {
				while (curr != null) {
					if (values[i] > curr.val) {
						if (curr.right == null) {
							curr.right = n;
							break;
						} else {
							curr = curr.right;
						}

					} else {
						if (curr.left == null) {
							curr.left = n;
							break;
						} else {
							curr = curr.left;
						}
					}

				}
			}
		}

		return root;
	}
}
