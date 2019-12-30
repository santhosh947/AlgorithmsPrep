package Practice_Nov_2019.DP;

class L88MergeSortedArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        for(int a: A)
          System.out.print(a+",");
         
        merge(A,3,B,3);
       
        System.out.println();
        for(int a: A)
          System.out.print(a+",");
       }
       
       public static void merge(int A[], int m, int B[], int n) {
         int i=m-1, j=n-1, k=m+n-1;
         while (i>-1 && j>-1) 
           A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
         
         while (j>-1)         
           A[k--]=B[j--];
     }
}