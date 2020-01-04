package Practice_Nov_2019.DP;

class L953VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        String[] s = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(isAlienSorted(s, order));
    }

    public static int[] map = new int[26];
    public static boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++)
        {
            map[order.charAt(i)-'a'] = i;
        }
        
        for(int i=1;i<words.length;i++)
        {
            if(compare(words[i-1],words[i]))
                return false;
        }
        return true;
    }
    
    public static boolean compare(String s, String t)
    {
        int m = s.length();
        int n = t.length();
        for(int i=0;i<m && i<n;i++)
        {
            if(s.charAt(i)!=t.charAt(i))
                return (map[s.charAt(i)-'a'] > map[t.charAt(i)-'a']);
        }
        return  m>n;
    }
}