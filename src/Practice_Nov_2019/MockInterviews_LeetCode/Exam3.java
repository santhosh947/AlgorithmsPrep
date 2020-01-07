package Practice_Nov_2019.MockInterviews_LeetCode;

import java.util.*;

import Prac2.ArrayListEx;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Exam3 {
    public static void main(String[] args) {
        String[] aaa = { "a", "b" };
        // System.out.println(shortestDistance(aaa,"a", "b"));

        TreeNode lleaf1 = new TreeNode(5);
        TreeNode rleaf1 = new TreeNode(-3);

        TreeNode rleaf2 = new TreeNode(2);
        TreeNode lleaf2 = new TreeNode(3);

        TreeNode rleaf3 = new TreeNode(11);

        rleaf1.right=rleaf3;

        TreeNode rleaf4 = new TreeNode(1);
        rleaf2.right=rleaf4;

        TreeNode root = new TreeNode(10);

        lleaf1.right = rleaf2;
        lleaf1.left = lleaf2;

        root.left = lleaf1;
        root.right = rleaf1;

        System.out.println(pathSum(root, 8));
    }

    static int count=0;
    public static int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        
        count = 0;       
        abs(root,sum);     
        return count;
    }

    private static void abs(TreeNode root, int sum) {
        if(root==null)
            return;
        rec_tree_traverse(root, sum,0,0,0);
        abs(root.left,sum);
        abs(root.right,sum);

    }

    private static void rec_tree_traverse(TreeNode root, int sum, int prev, int curr, int run_tot) {
        if(root == null)
            return;

        run_tot+=root.val;
        if(run_tot==sum)
            count++;
        
        rec_tree_traverse(root.left, sum, prev, curr, run_tot);
        rec_tree_traverse(root.right, sum, prev, curr, run_tot);
    }   

    public static int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;

        Map<String, List<Integer>> hm = new HashMap();

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i])) {
                List<Integer> l = hm.get(words[i]);
                l.add(i);
                hm.put(words[i], l);

            } else {
                List<Integer> l = new ArrayList();
                l.add(i);
                hm.put(words[i], l);
            }
        }

        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);

        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            }
        }
        return res;
    }
}