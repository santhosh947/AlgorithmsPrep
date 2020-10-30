package Practice_Nov_2019.Recurrsions;

import java.util.*;

class FBPrac1 {
    public static void main(String[] args) {
        System.out.println(numDecodings2("110"));
        System.out.println(numDecodings2("101"));
        System.out.println(numDecodings2("12"));
        System.out.println(numDecodings2("27"));
        System.out.println(numDecodings2("226"));

        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("101"));

        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("27"));
        System.out.println(numDecodings("226"));

        String[] e1 = { "David", "David3@m.co", "David4@m.co" };
        String[] e2 = { "David", "David0@m.co", "David1@m.co" };// ,{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}}

        String[] e3 = { "David", "David4@m.co", "David5@m.co" };
        String[] e4 = { "David", "David2@m.co", "David3@m.co" };
        String[] e5 = { "David", "David1@m.co", "David2@m.co" };

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList(e1));
        accounts.add(Arrays.asList(e2));

        accounts.add(Arrays.asList(e3));

        accounts.add(Arrays.asList(e4));
        accounts.add(Arrays.asList(e5));

        // List<List<String>> res = accountsMerge_working(accounts);
        System.out.println();

    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    private static class Node {
        String Name;
        HashSet<String> emails;

        public Node(String s, HashSet<String> e) {
            Name = s;
            emails = e;
        }
    }

    public static List<List<String>> accountsMerge_working(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>(); // <email node, neighbor nodes>
        Map<String, String> name = new HashMap<>(); // <email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<String>());
                }
                name.put(account.get(i), userName);

                if (i == 1)
                    continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }

        return res;
    }

    public static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Node> hm = new HashMap();
        HashSet<Node> res = new HashSet();

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            String n = accounts.get(i).get(0);
            HashSet<String> hs = new HashSet();
            Node nd1 = new Node(n, hs);
            for (int a = 1; a < accounts.get(i).size(); a++) {
                String e = accounts.get(i).get(a);
                if (hm.containsKey(e)) {
                    nd1 = hm.get(e);
                    HashSet<String> new_hs = nd1.emails;
                    Iterator it = hs.iterator();
                    while (it.hasNext()) {
                        String em1 = (String) it.next();
                        new_hs.add(em1);
                    }
                    hs = new_hs;
                }
                hm.put(e, nd1);
                hs.add(e);
            }
            res.add(nd1);

        }

        Iterator it2 = res.iterator();

        while (it2.hasNext()) {
            Node nd = (Node) it2.next();
            List<String> l = new ArrayList<>();
            l.add(nd.Name);

            PriorityQueue<String> pq = new PriorityQueue<>();

            HashSet<String> em = nd.emails;
            Iterator it_em = em.iterator();
            while (it_em.hasNext()) {
                String e1 = (String) it_em.next();
                pq.add(e1);
            }

            it_em = pq.iterator();
            while (it_em.hasNext()) {
                String e1 = (String) it_em.next();
                l.add(e1);
            }
            ans.add(l);
        }

        return ans;
    }

    public static int numDecodings(String s) {
        if (Integer.valueOf(s) <= 0 || s.indexOf('0') == 0)
            return 0;
        return recDecode(s, 0, s.length() - 1);
    }

    private static int recDecode(String s, int st, int end) {
        int res = 1;
        if (end - st == 1) {
            String str = s.substring(st, end + 1);
            // if(str.indexOf('0')==0)
            // return 0;
            int v = Integer.valueOf(s.substring(st, end + 1));
            if ((v >= 1 && v <= 10))
                return 1;
            else if (v >= 11 && v <= 26)
                return 2;
            else if (v > 26)
                return 1;
            else
                return 0;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            res -= 1;
            for (int j = i + 1; j < s.length() && j - i < 2; j++) {
                int child = recDecode(s, i, j);
                res += child;
            }
        }

        return res;
    }

}