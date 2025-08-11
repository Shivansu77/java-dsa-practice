package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 5
 * Topic: Arrays
 * Problem: Move all negative elements to one side of the array
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an
 * Output: array with negatives on left side (order not guaranteed)
 */
public class Q5MoveNegatives {
    public static void moveNegativesLeft(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[i] < 0) { i++; }
            else if (arr[j] >= 0) { j--; }
            else {
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
                i++; j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        moveNegativesLeft(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
