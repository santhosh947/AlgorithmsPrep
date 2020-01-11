package Practice_Nov_2019.MockInterviews_LeetCode.Uber;

class PracticeExam {
    public static void main(String[] args) {
        System.out.println(addTwoDigits(29));
    }

    public static int addTwoDigits(int n) {
        int t = n;
        int res = 0;
        while(t>0)
        {
            res+=t%10;
            t=t/10;
        }
        return res;
    }

    public static boolean isDiagonalMatrix(int[][] matrix) {
        int r=matrix.length;
        int c= matrix[0].length;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i!=j && matrix[i][j]!=0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}