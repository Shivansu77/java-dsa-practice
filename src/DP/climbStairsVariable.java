package DP;
import java.util.*;

public class climbStairsVariable {
    public static void main(String[] args) {
        int n = 5;
        // Example: At stair 0 you can jump 3 steps, at stair 1 - 3, at 2 - 0, at 3 - 2, at 4 - 2
        int[] arr = {3, 3, 0, 2, 2};

        int[] dp = new int[n + 1];
        dp[n] = 1; // Only 1 way to reach the end from the end

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }
}
