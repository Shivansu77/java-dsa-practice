package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 4
 * Topic: Arrays
 * Problem: Given an array of 0,1,2 sort without using sorting algo (Dutch National Flag)
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an (each 0/1/2)
 * Output: sorted array
 */
public class Q4Sort012 {
    public static void sort012(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low]; arr[low] = arr[mid]; arr[mid] = t;
                low++; mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // 2
                int t = arr[mid]; arr[mid] = arr[high]; arr[high] = t;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        sort012(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
