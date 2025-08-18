package DP;

public class numsq {
    public static int numSquares(int n) {
       return helper( n);
    }
    public static int helper(int n){
        //this question is pretty straightForward
        if(n==0)return 0;
        if(n==1)return 1;
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int val=1+helper(n-i*i);
            minCount=Math.min(val,minCount);
        }
        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(helper(12));
    }
}
