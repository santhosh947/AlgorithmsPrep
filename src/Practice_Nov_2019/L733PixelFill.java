package Practice_Nov_2019;

class L733PixelFill {
    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,1}};
        int[][] r = floodFill(a, 1,1,1);

        for(int i=0;i<r.length;i++)
        {
            System.out.println();
            for(int j=0;j<r[0].length;j++)
            {
                System.out.print(r[i][j]+",");
            }
        }
        
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int[][] visited=new int[image.length][image[0].length];
        dfs(image, sr,sc,newColor, image[sr][sc],visited);

        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor,int[][] v) {

        if(sr<0 || sr>image.length-1 || sc<0 || sc>image[0].length-1 || image[sr][sc]!=oldColor || v[sr][sc]!=0)
            return;

        image[sr][sc]= newColor;
        v[sr][sc]=1;
        dfs(image, sr+1, sc,newColor, oldColor,v);        
        dfs(image, sr-1, sc,newColor, oldColor,v);
        dfs(image, sr, sc-1,newColor, oldColor,v);
        dfs(image, sr, sc+1,newColor, oldColor,v);
    }
}