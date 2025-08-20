package DP;

public class GoldMine {
    public static void main(String[] args) {
        int n = 4; // number of rows
        int m = 4; // number of columns

        int[][] arr = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };
        int [][]dp=new int[n+1][m+1];

        for(int j=m-1;j>=0;j--){
            for(int i=n-1;i>=0;i--){
                if(i==0){
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j+1])+arr[i][j];
                }else if(i==n-1){
                    dp[i][j]=Math.max(dp[i][j+1],dp[i-1][j+1])+arr[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1]))+arr[i][j];
                }
            }
        }
        int max=0;;
        for(int i=0;i<n;i++){
            if(max<dp[i][0]){
                max=dp[i][0];
            }
        }
        System.out.print(max);
    }
}
