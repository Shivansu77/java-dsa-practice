package recursionBacktracking;

/**
 * K-th Symbol in Grammar (LeetCode 779)
 *
 * Grammar definition:
 * Row 1: 0
 * Row n: replace 0 -> 01 and 1 -> 10 applied to row n-1
 *
 * This recursive solution uses the observation that the first half of row n
 * equals row n-1; the second half is the bitwise complement of row n-1.
 *
 * Time complexity: O(n), Space: O(n) recursion depth.
 */
public class Grammar {
    /**
     * Returns the k-th symbol (1-indexed) in row n.
     */
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0; // base row
        int mid = (int)(Math.pow(2, n - 1) / 2); // half length of row n
        if (k <= mid) {
            // In the first half, symbol equals the corresponding symbol in previous row
            return kthGrammar(n - 1, k);
        } else {
            // In the second half, symbol is complement of corresponding in previous row
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
}
