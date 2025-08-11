package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 9
 * Topic: Arrays
 * Problem: Minimise the maximum difference between heights
 *
 * Input (stdin):
 *  n k
 *  a1 a2 ... an (heights)
 * Output: minimized difference
 */
public class Q9MinimizeHeightsDiff {
    public static int minimizeDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return 0;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        if (small > big) { int t = small; small = big; big = t; }
        for (int i = 1; i < n-1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;
            if (subtract < 0) continue;
            int min = Math.min(small, subtract);
            int max = Math.max(big, add);
            ans = Math.min(ans, max - min);
        }
        return Math.max(0, ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        System.out.println(minimizeDiff(arr, k));
    }
}
