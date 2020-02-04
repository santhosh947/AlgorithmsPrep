package Practice_Nov_2019.DP;

class L96UniqueBinarySearchTrees {
    public static void main(String[] args) {
       // System.out.println(numTrees(2));
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] cache = new int[n+1];
        cache[0]=0;
        cache[1]=1;
        if(n>1)
        {
            findBST(n,cache,2);
        }
        return cache[n];
    }
    private static void findBST(int n, int[] cache, int curr)
    {
        if(curr>n){
            return;
        }
        int combo=0;
        for(int i=1;i<=curr;i++)
        {
           // int root = i;
            int left_child_elems = i-1;
            int right_child_elems = curr - i;
            combo += (cache[left_child_elems]==0?1:cache[left_child_elems])*(cache[right_child_elems]==0?1:cache[right_child_elems]);
        }
        cache[curr]=combo;
        findBST(n, cache, curr+1);
    }
}