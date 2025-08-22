package DP;

public class TargetSumSubset {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3}; // example array
        int target = 10;
        int n = arr.length;
        boolean [][]dp=new boolean[n+1][target+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }else{
                        int val=arr[i-1];
                        if(val<=j){
                            if(dp[i-1][j-val]){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(dp[n][target]);
    }
}
