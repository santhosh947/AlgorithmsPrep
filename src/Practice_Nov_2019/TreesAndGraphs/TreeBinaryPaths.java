package Practice_Nov_2019.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

class TreeBinaryPaths {
    public static void main(String[] args) {
        TreeNode lleaf1 = new TreeNode(2);
        TreeNode rleaf1 = new TreeNode(3);

        TreeNode rleaf2 = new TreeNode(5);

        TreeNode root = new TreeNode(1);

        lleaf1.right = rleaf2;

        root.left = lleaf1;
        root.right = rleaf1;

        List<String> res = binaryTreePaths(root);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder("");
        List<String> paths = new ArrayList();

        if (root == null)
            return paths;
        dfs(root, paths, path);

        return paths;

    }

    public static void dfs(TreeNode r, List<String> paths, StringBuilder path) {
        if (r == null)
            return;

        if (r.left == null && r.right == null) {
            path.append(r.val);
            paths.add(path.toString());
            //path = new StringBuilder("");
            return;
        }

        path.append(r.val);

        if (r.left != null) {
            StringBuilder leftPath = new StringBuilder(path.toString());
            leftPath.append("->");

            dfs(r.left, paths, leftPath);
            //path.append("->");

        }
        if (r.right != null) {

            StringBuilder rightPath = new StringBuilder(path.toString());
            rightPath.append("->");
            dfs(r.right, paths, rightPath);

        }

       // return;

    }
}