
public class BuildBSTFromPreorder {
	public static void main(String[] args) {
		int[] arr= {10,5,1,7,40,50};
		Node root = BuildBST(arr);
		System.out.println("end");
	}

	public static Node BuildBST(int[] num) {
		Node head = null;
		Node t = head;

		if (num == null || num.length == 0)
			return null;

		for (int i = 0; i < num.length; i++) {
			Node n = new Node(num[i]);
			if (head == null) {
				head = n;
				t = head;
			} else {
				insert(t, n);
			}

		}
		return head;

	}

	private static void insert(Node r, Node n) {

		if (r.val < n.val) {
			if (r.right == null) {
				r.right = n;
				return;
			}
			insert(r.right, n);
		} else {
			if (r.left == null) {
				r.left = n;
				return;
			}
			insert(r.left, n);
		}
	}
}
