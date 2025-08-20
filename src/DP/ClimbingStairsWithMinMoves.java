import java.util.*;

public class ClimbingStairsWithMinMoves {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        int n = arr.length;
        Integer[] dp = new Integer[n + 1];

        dp[n] = 0; // base case (at the end)

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }

        System.out.println(dp[0]); // Minimum moves
    }
}
