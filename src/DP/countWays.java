package DP;

public class countWays {
    public static int countways(int n) {
        // your code here
        if(n==0 || n==1){
            return 1;
        }
        int left=countways(n-1);
        int right=countways(n-2);
        return left+right;

    }

    public static void main(String[] args) {
       System.out.println(countways(4));
    }
}
