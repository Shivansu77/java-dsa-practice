package DP;

public class besttimetobuyandsell {
    public int maxProfit(int[] prices) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(min<prices[i]){
                int profit=prices[i]-min;
                max=Math.max(max,profit);
            }else{
                min=prices[i];
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
