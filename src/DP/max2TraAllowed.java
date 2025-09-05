package DP;

public class max2TraAllowed {
    public static int maxProfit(int[] prices) {
        // code here
        int n=prices.length;
        int []dpLeft=new int[n];
        int leftLeast=prices[0];
        int maxLeft=0;
        for(int i=1;i<n;i++){
            if(leftLeast<prices[i]){
                int profit=prices[i]-leftLeast;
                maxLeft=Math.max(maxLeft,profit);
            }else{
                leftLeast=prices[i];
            }
            dpLeft[i]=maxLeft;

        }

        int []dpRight=new int[n];
        int rightmax=prices[n-1];
        int maxRight=0;
        for(int i=n-2;i>=0;i--){
            if(rightmax>prices[i]){
                int profit=rightmax-prices[i];
                maxRight=Math.max(maxRight,profit);
            }else{
                rightmax=prices[i];
            }
            dpRight[i]=maxRight;
        }

        int maxTra=0;
        for(int i=0;i<n;i++){
            if(dpLeft[i]+dpRight[i]>maxTra){
                maxTra=dpLeft[i]+dpRight[i];
            }
        }
        return maxTra;
    }
}
