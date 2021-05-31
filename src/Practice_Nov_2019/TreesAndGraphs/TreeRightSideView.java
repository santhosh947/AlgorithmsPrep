package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class TreeRightSideView {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode rl1 = new TreeNode(2);
        TreeNode rr1 = new TreeNode(3);

        r.left = rl1;
        r.right = rr1;

        TreeNode rr2 = new TreeNode(5);
        TreeNode rr3 = new TreeNode(4);

        // rl1.right = rr2;
        // rr1.right = rr3;

        rl1.left = rr3;

        List<Integer> res = rightSideView(r);

        System.out.println("***************************************");

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }

        System.out.println();
        System.out.println("***************************************");
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        Stack<TreeNode> st = new Stack<TreeNode>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();

        qu.add(root);
        st.push(root);
        boolean flag = true;
        while (!st.isEmpty() || !qu.isEmpty()) {
            TreeNode temp = st.pop();
            if (flag) {
                res.add(temp.val);
                flag = false;
            }

            if (st.isEmpty() && !qu.isEmpty()) {
                flag = true;
                int len = qu.size();
                while (!qu.isEmpty() && len > 0) {
                    temp = qu.remove();
                    if (temp.left != null) {
                        st.push(temp.left);
                        qu.add(temp.left);
                    }
                    if (temp.right != null) {
                        st.push(temp.right);
                        qu.add(temp.right);
                    }
                    len--;
                }
            }
        }

        return res;
    }

    public static List<Integer> rightSideView_old(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;

        int lvl = 1;
        Map<Integer, TreeNode> hm = new HashMap();
        treeTraversalRec(root, lvl, hm);

        for (int i = 0; i < hm.size(); i++) {
            res.add(hm.get(i + 1).val);
        }

        return res;
    }

    public static void treeTraversalRec(TreeNode root, int lvl, Map<Integer, TreeNode> hm) {
        if (root == null)
            return;

        if (!hm.containsKey(lvl))
            hm.put(lvl, root);

        treeTraversalRec(root.right, ++lvl, hm);
        treeTraversalRec(root.left, lvl, hm);

        --lvl;
        return;

    }
}