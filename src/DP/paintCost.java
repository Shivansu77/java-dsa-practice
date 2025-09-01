package DP;

public class paintCost {
    public static int paintCost(int n, int k, int[][] costs) {
        int [][]dp = new int[n][k];

        // base case
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        // fill dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int s = 0; s < k; s++) {
                    if (j != s) {
                        min = Math.min(min, dp[i-1][s]);  // ✅ fixed
                    }
                }
                dp[i][j] = costs[i][j] + min;
            }
        }

        // result = minimum in last row
        int min = Integer.MAX_VALUE;
        for (int s = 0; s < k; s++) {
            min = Math.min(min, dp[n-1][s]);
        }

        return min;
    }
}
