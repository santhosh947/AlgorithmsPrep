package Practice_Nov_2019.TreesAndGraphs;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class L863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode rl1 = new TreeNode(5);
        TreeNode rr1 = new TreeNode(1);

        r.left = rl1;
        r.right = rr1;

        TreeNode rr2 = new TreeNode(6);
        TreeNode rr3 = new TreeNode(2);

        rl1.right = rr2;
        rl1.left = rr3;

        TreeNode rr4 = new TreeNode(7);
        TreeNode rl4 = new TreeNode(4);

        rr3.left = rl4;
        rr3.right = rr4;

        TreeNode rr5 = new TreeNode(0);
        TreeNode rl5 = new TreeNode(8);

        rr1.left = rl5;
        rr1.right = rr5;

        List<Integer> res = distanceK(r, rl1, 2);
        for(int tt: res)
        {
        System.out.println(tt);
        }

        TreeNode t_r = new TreeNode(0);
        TreeNode t_rl1 = new TreeNode(1);
        t_r.left = t_rl1;

        TreeNode t_rr2 = new TreeNode(2);
        TreeNode t_rr3 = new TreeNode(3);

        t_rl1.right = t_rr2;
        t_rl1.left = t_rr3;

        List<Integer> res2 = distanceK(t_r, t_rr2, 1);
        for (int tt : res2) {
            System.out.println(tt);
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> hs = new ArrayList();
        Set<TreeNode> processed = new HashSet();
        Queue<TreeNode> st = new LinkedList<>();

        int pt = 0;
        findPath(target, target, K, pt, hs, processed);
        processed.add(target);
        pt++;
        if (pt <= K && findTarget(root, target, st)) {  
            if (pt == K) {
                hs.add(st.remove().val);
                pt++;
            }
            while (pt <= K && !st.isEmpty()) {
                TreeNode c = st.remove();
                if (!processed.contains(c)) {
                    // find the paths above the ele
                    findPath(c, target, K, pt, hs, processed);
                }
                pt++;
            }
        }
        return hs;
    }

    private static void findPath(TreeNode r, TreeNode target, int k, int pt, List<Integer> hs,
            Set<TreeNode> processed) {
        if (r == null || processed.contains(r)) {
            return;
        }
        if (pt == k) {
            hs.add(r.val);
            processed.add(r);
            return;
        }
        if(!processed.contains(r))
        {
            if(!processed.contains(r.left))
                findPath(r.left, target, k, pt + 1, hs, processed);
            if(!processed.contains(r.right))
                findPath(r.right, target, k, pt + 1, hs, processed);
            processed.add(r);

        }
        //processed.add(r);
    }

    private static boolean findTarget(TreeNode r, TreeNode t, Queue<TreeNode> st) {
        if (r == null) {
            return false;
        }
        if (r == t) {
            return true;
        }
        boolean l = findTarget(r.left, t, st);
        if (l) {
            st.add(r);
            return true;
        }
        boolean rig = findTarget(r.right, t, st);
        if (rig) {
            st.add(r);
            return rig;
        }
        return false;
    }
}