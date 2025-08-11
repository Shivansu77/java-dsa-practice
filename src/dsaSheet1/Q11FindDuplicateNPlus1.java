package dsaSheet1;

import java.util.*;

/**
 * Love Babbar DSA Sheet – Question 11
 * Topic: Arrays
 * Problem: find duplicate in an array of N+1 Integers (values 1..N, one duplicate appears at least twice)
 * Uses Floyd's cycle detection in value-as-next-index graph.
 *
 * Input (stdin):
 *  n (length)  followed by n integers in range [1, n-1]
 * Output: duplicate value
 */
public class Q11FindDuplicateNPlus1 {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.hasNextInt() ? sc.nextInt() : 0;
        System.out.println(findDuplicate(arr));
    }
}
