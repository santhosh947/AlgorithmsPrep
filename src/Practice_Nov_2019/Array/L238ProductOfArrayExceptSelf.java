package Practice_Nov_2019.Array;

class L238ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        //1,1,2,6
        //24,12,4,1
        int[] r = productOfArray(a);

        for(int t: r)
        {
            System.out.print(t + ",");
        }
    }

    public static int[] productOfArray(int[] a)
    {
        int[] res = new int[a.length];
        res[0]=1;

        for(int i=1;i<a.length;i++)
        {
            res[i]=1;
            res[i]=res[i-1]*a[i-1];
        }

        int[] back = new int[a.length];
        back[a.length-1]=1;
        for(int i=a.length-2;i>-1;i--)
        {
            back[i]=1;
            back[i]= back[i+1]*a[i+1];
        }

        for(int i=0;i<res.length;i++)
        {
            res[i]*=back[i];
        }

        return res;
    }
}