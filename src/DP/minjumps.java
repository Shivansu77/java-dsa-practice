package DP;

public class minjumps {
    static int minJumps(int[] arr) {
        int n = arr.length;

        // array to memoize values
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        // If end cannot be reached.
        if (dp[0] == Integer.MAX_VALUE)
            return -1;

        return dp[0];
    }

}
