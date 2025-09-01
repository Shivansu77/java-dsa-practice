package DP;

public class houserobber2 {
    public int rob(int[] arr) {
        int n=arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int case1=roblinear(arr,0,n-2);
        int case2=roblinear(arr,1,n-1);
        return Math.max(case1,case2);
    }
    public int roblinear(int []arr,int start,int end){
        int inc=0;
        int exc=0;

        for(int i=start;i<=end;i++){
            int ninc=exc+arr[i];
            int nexc=Math.max(inc,exc);
            inc=ninc;
            exc=nexc;
        }
        int ans=Math.max(inc,exc);
        return ans;
    }
}
