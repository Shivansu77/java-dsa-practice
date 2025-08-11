package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 8
 * Topic: Arrays
 * Problem: find Largest sum contiguous Subarray (Kadane)
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an
 * Output: max sum
 */
public class Q8KadaneMaxSubarray {
    public static long maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        long best = arr[0];
        long cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        System.out.println(maxSubArraySum(arr));
    }
}
