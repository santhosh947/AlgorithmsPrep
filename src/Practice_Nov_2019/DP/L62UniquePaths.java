package Practice_Nov_2019.DP;

class L62UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(7,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++)
        {
            g[i][0]=1;
        }

        for(int i=0;i<n;i++)
        {
            g[0][i]=1;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                g[i][j]= g[i-1][j]+g[i][j-1];
            }
        }

        return g[m-1][n-1];
    }
}