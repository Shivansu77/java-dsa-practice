package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 12
 * Topic: Arrays
 * Problem: Merge 2 sorted arrays without using Extra space
 * Method: Gap method (Shell sort like)
 *
 * Input (stdin):
 *  m n
 *  arr1 (m sorted)
 *  arr2 (n sorted)
 * Output:
 *  first line: merged arr1 (m values)
 *  second line: merged arr2 (n values)
 */
public class Q12MergeTwoSortedNoExtraSpace {
    public static void merge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int gap = nextGap(n + m);
        while (gap > 0) {
            int i = 0, j = gap;
            while (j < n + m) {
                if (j < n) {
                    // both in a
                    if (a[i] > a[j]) swapA(a, i, j);
                } else if (i < n) {
                    // i in a, j in b
                    if (a[i] > b[j - n]) swapAB(a, b, i, j - n);
                } else {
                    // both in b
                    if (b[i - n] > b[j - n]) swapB(b, i - n, j - n);
                }
                i++; j++;
            }
            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void swapA(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
    private static void swapB(int[] b, int i, int j) { int t = b[i]; b[i] = b[j]; b[j] = t; }
    private static void swapAB(int[] a, int[] b, int i, int j) { int t = a[i]; a[i] = b[j]; b[j] = t; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int m = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        for (int j = 0; j < m; j++) b[j] = sc.hasNextInt() ? sc.nextInt() : 0;
        merge(a, b);
        System.out.println(join(a));
        System.out.println(join(b));
    }

    private static String join(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
