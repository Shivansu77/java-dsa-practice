package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 10
 * Topic: Arrays
 * Problem: Minimum no. of Jumps to reach end of an array
 * Each element arr[i] is max jump length at i. Return -1 if unreachable.
 *
 * Input (stdin):
 *  n
 *  a1 a2 ... an
 * Output: minimum jumps
 */
public class Q10MinJumpsToEnd {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        System.out.println(minJumps(arr));
    }
}
