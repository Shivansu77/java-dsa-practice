package DP;

public class maxsumwithoAdj {
    int findMaxSum(int arr[]) {
        // code here
        int inc=arr[0];
        int exc=0;

        for(int i=1;i<arr.length;i++){
            int ninc=exc+arr[i];
            int nexc=Math.max(inc,exc);
            inc=ninc;
            exc=nexc;
        }
        return Math.max(inc,exc);
    }
}
