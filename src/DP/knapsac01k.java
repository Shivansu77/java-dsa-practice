package DP;
import java.util.*;
public class knapsac01k {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int [][]dp=new int[n+1][W+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=wt[i-1]){
                    int rCap=j-wt[i-1];
                    if(dp[i-1][rCap]+val[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][rCap]+val[i-1];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        int val[]=new int[w];
        int wt[]=new int[w];
        for(int i=0;i<w;i++){
            val[i]=sc.nextInt();
        }
        for(int i=0;i<w;i++){
            wt[i]=sc.nextInt();
        }
        System.out.print(knapsack(w,val,wt));
    }
}
