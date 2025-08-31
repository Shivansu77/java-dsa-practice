package DP;

public class partionequalSubset {
    static boolean equalPartition(int arr[]) {
        // code here
        int n=arr.length;
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        int [][]dp=new int[n+1][sum+1];
        for(int []row:dp)Arrays.fill(row,-1);
        if(sum%2!=0)return false;

        return helper(arr,n,sum/2,dp);
    }
    static boolean helper(int arr[],int n,int sum,int [][]dp){
        if(sum==0)return true;
        if(n==0)return false;
        if(dp[n][sum]!=-1)return dp[n][sum]==1;
        boolean result;
        if(arr[n-1]>sum){
            result=helper(arr,n-1,sum,dp);//just skip it
        }else{
            result=helper(arr,n-1,sum,dp)||helper(arr,n-1,sum-arr[n-1],dp);
        }

        dp[n][sum]=result?1:0;
        return result;
    }
}
