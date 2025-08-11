package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 1
 * Topic: Arrays
 * Problem: Reverse the array
 *
 * Usage (stdin):
 *  n
 *  a1 a2 a3 ... an
 * Prints the reversed array as space-separated integers on one line.
 */
public class Q1ReverseArray {

    /**
     * Reverses the input array in-place.
     */
    public static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }

    /**
     * Simple console runner for quick manual testing.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return; // no input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) arr[i] = sc.nextInt();
            else arr[i] = 0;
        }
        reverse(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
