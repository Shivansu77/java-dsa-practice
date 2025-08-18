package DP;

import java.util.Scanner;

public class climbingStairsWithjumps {
    public static void main(String[] args) {
        // define n (number of stairs)
        int n = 5;

        // define max jumps allowed from each step
        int[] arr = {3, 3, 0, 2, 2};

        // dp[i] = number of ways to reach end from step i
        int[] dp = new int[n + 1];

        dp[n] = 1; // base case → 1 way at the top

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        // print result
        System.out.println("Total ways = " + dp[0]);
    }

}
