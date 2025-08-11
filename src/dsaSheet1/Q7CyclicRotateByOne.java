package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 7
 * Topic: Arrays
 * Problem: Write a program to cyclically rotate an array by one (right rotate)
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an
 * Output: rotated array
 */
public class Q7CyclicRotateByOne {
    public static void rotateByOneRight(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) arr[i] = arr[i - 1];
        arr[0] = last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        rotateByOneRight(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
