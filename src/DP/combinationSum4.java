package DP;

public class combinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int []dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    int ramp=i-num;
                    dp[i]+=dp[ramp];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int []nums={1,2,3};
        System.out.println(combinationSum4(nums,4));
    }

}
