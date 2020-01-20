package Practice_Nov_2019;

class PeakOrValleyProblem {

    public static void main(final String[] args) {
        final PeakOrValleyProblem main = new PeakOrValleyProblem();
        main.process();
    }

    private void process() {
        System.out.println(getPeakOrVally(new int[] { 3, 2, 1, 0, 1 }));
        System.out.println(getPeakOrVally(new int[] { 4, 5, 6, 7, 8, 9, 8, 7 }));
        System.out.println(getPeakOrVally(new int[] { 1, 2, 3 }));
        System.out.println(getPeakOrVally(new int[] { 1, 2, 3, 2, 1, 2 }));
        System.out.println(getPeakOrVally(new int[] { 1, 2, 3, 2, 3, 2 }));
    }

    private int getPeakOrVally(final int[] arr) {
        if(arr.length<3)
            return -1;

        boolean valley = false;
        boolean peak = false;
        int ind = -1;

        for(int i=1;i<arr.length-1;i++)
        {
            if(arr[i-1]<arr[i] && arr[i]> arr[i+1])
            {
                if(valley || peak)
                    return -1;
                
                ind = i;
                peak=true;
            }
            else if(arr[i-1]>arr[i] && arr[i]< arr[i+1])
            {
                if(valley || peak)
                    return -1;
                
                valley=true;
                ind = i;
            }
        }
        return ind;
    }

    private int getPeakOrVally3(final int[] arr) {
        if (arr.length < 3)
            return -1;

        boolean peak = false, valley = false;
        int index = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                if (valley || peak)
                    return -1;
                valley = true;
                index = i;
            } else if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                if (valley || peak)
                    return -1;
                peak = true;
                index = i;
            }
        }
        return index;
    }
}