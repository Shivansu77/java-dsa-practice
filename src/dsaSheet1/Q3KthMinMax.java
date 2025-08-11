package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 3
 * Topic: Arrays
 * Problem: Find the "Kth" max and min element of an array
 *
 * Input (stdin):
 *  n k
 *  a1 a2 ... an
 * Output: "kthMin kthMax"
 */
public class Q3KthMinMax {
    public static int[] kthMinMax(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int kthMin = copy[k - 1];
        int kthMax = copy[copy.length - k];
        return new int[]{kthMin, kthMax};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.hasNextInt() ? sc.nextInt() : 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] ans = kthMinMax(arr, k);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
