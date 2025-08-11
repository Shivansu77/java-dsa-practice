package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 2
 * Topic: Arrays
 * Problem: Find the maximum and minimum element in an array
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an
 * Output: "min max"
 */
public class Q2MinMaxArray {
    public static int[] minMax(int[] arr) {
        if (arr == null || arr.length == 0) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int mn = arr[0], mx = arr[0];
        for (int v : arr) {
            if (v < mn) mn = v;
            if (v > mx) mx = v;
        }
        return new int[]{mn, mx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] ans = minMax(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
