package DP;
import java.util.*;

public class Mincostpath {
    public static void main(String[] args) {
        // Example values
        int n = 3;
        int m = 3;

        int[][] arr = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = arr[i][j];  // destination cell
                } else if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j]; // last row
                } else if (j == m - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j]; // last column
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }

        System.out.println("Minimum cost path: " + dp[0][0]);
    }
}
