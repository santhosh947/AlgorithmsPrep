package Old_files;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	public TreeLinkNode(int v) {
		this.val = v;
	}
}

public class LinkedListNextRightPointer {
	public void connect(TreeLinkNode root) {

		if (root == null)
			return;

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		// 1
		queue.offer(root);

		while (!queue.isEmpty()) {
			int numOfElements = queue.size();

			for (int i = 0; i < numOfElements; i++) {
				if (queue.peek() != null) {
					if (queue.peek().left != null) {
						queue.offer(queue.peek().left);
					}

					if (queue.peek().right != null) {
						queue.offer(queue.peek().right);
					}
					TreeLinkNode nd = queue.poll();

					if (i == numOfElements - 1) {
						nd.next = null;
					} else {
						nd.next = queue.peek();
					}
				}
			}
		}
	}
}
