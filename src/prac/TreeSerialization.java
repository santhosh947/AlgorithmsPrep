package prac;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialization {

	public static void main(String[] args) {

		TreeNode hd = new TreeNode(1);

		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r1l = new TreeNode(6);
		TreeNode r1r = new TreeNode(7);

		hd.left = l1;
		hd.right = r1;
		r1.left = r1l;
		r1.right = r1r;
		String s=serialize2(hd);
		System.out.println(s);
		TreeNode newrt = deserialize2(s);
		String t = serialize2(newrt);
		if(s.equals(t))
		{
			System.out.println("EQUALS");
		}
		else
		{
			System.out.println("NOT EQUALS");
		}
	}
	
	
	private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize2(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

	public static String serialize(TreeNode t) {
		if (t == null)
			return "";

		return inOrderTraversel(t);
	}

	public static TreeNode deserialize(String s) {
		TreeNode root = null;
		if (s == null)
			return null;
		if(s=="")
            return root;

		String[] nodes = s.split(",");
		root = new TreeNode(Integer.valueOf(nodes[0]));
		TreeNode temp = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(temp);
		int a = 0;
		int count=0;
		while (!q.isEmpty() && a < nodes.length) {
			int i = a + 1;
			if (!nodes[a].equals("null") && Integer.valueOf(nodes[a]) == q.peek().val) {
				temp = q.poll();
				if ((2 * i - 1-count)<nodes.length && !nodes[2 * i - 1-count].equals("null")) {
					temp.left = new TreeNode(Integer.valueOf(nodes[2 * i - 1-count]));
					q.add(temp.left);
				} else {
					temp.left = null;
				}
				if ((2 * i-count)<nodes.length && !nodes[2 * i-count].equals("null")) {
					temp.right = new TreeNode(Integer.valueOf(nodes[2 * i-count]));
					q.add(temp.right);
				} else {
					temp.right = null;
				}
			}
			if(nodes[a].equals("null"))
				count++;
			a++;
		}
		return root;
	}

	public static String inOrderTraversel(TreeNode t) {
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (t == null)
			return "";

		q.add(t);
		res.append(t.val);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			// res.append(temp.val);
			if (temp.left == null) {
				res.append(",");

				res.append("null");
			} else {
				q.add(temp.left);
				res.append(",");

				res.append(temp.left.val);
			}
			if (temp.right == null) {
				res.append(",");

				res.append("null");
			} else {
				res.append(",");

				q.add(temp.right);
				res.append(temp.right.val);
			}
		}
		return res.toString();
	}
}
