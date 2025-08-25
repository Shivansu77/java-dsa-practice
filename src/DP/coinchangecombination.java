package DP;

public class coinchangecombination {
    public static void main(String[] args) {
        int[] arr = {2,3,5};  // coin denominations
        int amt = 7;            // target amount

        int[] dp = new int[amt + 1];
        dp[0] = 1;  // base case: 1 way to make 0 amount

        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j <= amt;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        System.out.print(dp[amt]);
    }

}
