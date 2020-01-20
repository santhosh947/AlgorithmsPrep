package Practice_Nov_2019.Array;

class L41FirstMissingPositive {
    public static void main(String[] args) {
        int[] in1= {1,2,0};
        int[] in2= {7,4,-1,1};
        int[] in3 = {7,8,9,11,12};

        System.out.println(firstMissingPositive(in1));
        System.out.println(firstMissingPositive(in2));
        System.out.println(firstMissingPositive(in3));
    }


    public static int firstMissingPositive(int[] A) {
       int i=0;
       while(i<A.length)
       {
          if(A[i]<=0 || A[i]>A.length || A[i]==i+1)
                i++;
          else if(A[A[i]-1]!=A[i])
                swap(A, A[i]-1, i);
          else 
            i++;
       }

       i=0;

       while(i<A.length && A[i]==i+1)
       {
           i++;
       }

       return i+1;
        
    }

    private static void swap(int[] A, int i,int j)
    {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
















    public static int firstMissingPositive_op(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) 
                i++;
            else if(A[A[i]-1] != A[i]) 
                swap_op(A, i, A[i]-1);
            else 
                i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) 
            i++;
        return i+1;
    }
    
    private static void swap_op(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int firstMissingPositive2(int[] A) {
        int n=A.length;
        if(n==0)
            return 1;
        int k=partition(A)+1;
        int temp=0;
        int first_missing_Index=k;
        for(int i=0;i<k;i++){
            temp=Math.abs(A[i]);
            if(temp<=k)
                A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
        }
        for(int i=0;i<k;i++){
            if(A[i]>0){
                first_missing_Index=i;
                break;
            }
        }
        return first_missing_Index+1;
    }
    
    public static int partition(int[] A){
        int n=A.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(A[i]>0){
                q++;
                swap2(A,q,i);
            }
        }
        return q;
    }
    
    public static void swap2(int[] A, int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }
}