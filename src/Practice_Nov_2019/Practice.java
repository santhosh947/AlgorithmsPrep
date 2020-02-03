package Practice_Nov_2019;

import java.util.*;

class point2{
    char c;
    int val;
    point2(char cc, int v)
    {
        c=cc;
        val=v;
    }

}

class pointComprator implements Comparator<point2>
{
    @Override
    public int compare(point2 o1, point2 o2)
    {
        if(o1.val>o2.val)
            return -1;
        else if(o2.val>o1.val)
            return 1;
        else 
            return 0;
    }   
}
class Practice {
    public static void main(String[] args) {
        System.out.println(reorganizeString3("aab"));
    }

    public static String reorganizeString3(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }

    public static String reorganizeString(String S) {
        Map<Character, Integer> hm = new HashMap();

        char[] cc = S.toCharArray();
        for (char c : cc) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<point2> pq = new PriorityQueue<>(new pointComprator());
        point2 a = new point2('a',2);
        point2 b = new point2('b',1);

        pq.add(a);
        pq.add(b);

        while(!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }


        int i = 1;
        for (i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i))
                break;
        }
        if (i == S.length())
            return S;

        StringBuilder op = new StringBuilder();
        String res = buildString(S, i, hm, op);
        return res;
    }



    private static String buildString(String s, int i, Map<Character, Integer> hm, StringBuilder op) {
        //String res = "";


        return op.toString();
    }

    public static String reorganizeString_sol(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) 
                return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>();

        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}