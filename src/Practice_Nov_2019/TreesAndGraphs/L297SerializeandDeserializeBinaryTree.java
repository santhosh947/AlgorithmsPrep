package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;


class L297SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode r = deserialize("1,X,2,3,X,X,X");
        System.out.println(serialize(r));

        TreeNode r2 = deserialize("1,2,X,X,3,4,X,X,5,X,X");
        System.out.println(serialize(r2));
    }
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
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
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}