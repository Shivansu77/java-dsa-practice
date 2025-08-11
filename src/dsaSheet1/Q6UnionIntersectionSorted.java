package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 6
 * Topic: Arrays
 * Problem: Find the Union and Intersection of the two sorted arrays
 *
 * Input (stdin):
 *  m n
 *  arr1 (m sorted ints)
 *  arr2 (n sorted ints)
 * Output:
 *  first line: union as space-separated
 *  second line: intersection as space-separated
 */
public class Q6UnionIntersectionSorted {
    public static List<Integer> unionSorted(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0; Integer last = null;
        while (i < a.length && j < b.length) {
            int v;
            if (a[i] < b[j]) { v = a[i++]; }
            else if (a[i] > b[j]) { v = b[j++]; }
            else { v = a[i]; i++; j++; }
            if (last == null || v != last) { res.add(v); last = v; }
        }
        while (i < a.length) { int v = a[i++]; if (last == null || v != last) { res.add(v); last = v; } }
        while (j < b.length) { int v = b[j++]; if (last == null || v != last) { res.add(v); last = v; } }
        return res;
    }

    public static List<Integer> intersectionSorted(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0; Integer last = null;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
            else {
                if (last == null || a[i] != last) { res.add(a[i]); last = a[i]; }
                i++; j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) a[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        for (int j = 0; j < n; j++) b[j] = sc.hasNextInt() ? sc.nextInt() : 0;
        List<Integer> uni = unionSorted(a, b);
        List<Integer> inter = intersectionSorted(a, b);
        System.out.println(join(uni));
        System.out.println(join(inter));
    }

    private static String join(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
