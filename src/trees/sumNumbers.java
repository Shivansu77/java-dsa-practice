package trees;

/**
 * Computes the sum of all root-to-leaf numbers in a binary tree.
 * Each path from root to leaf is interpreted as a base-10 number formed by concatenating node values.
 * For example, for a tree like:
 *     1
 *    / \
 *   2   3
 * Paths are 1->2 (number 12) and 1->3 (number 13), so the sum is 25.
 */
public class sumNumbers {
    /**
     * Entry method: returns the sum of all root-to-leaf path numbers.
     * If root is null, the sum is 0.
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    /**
     * Depth-first traversal maintaining the value built so far along the current path.
     *
     * @param root current node in traversal
     * @param sum  number built from the root down to the parent of current node
     * @return sum of numbers for all root-to-leaf paths in this subtree
     */
    public int helper(TreeNode root, int sum) {
        // Base case: empty subtree contributes 0 to the total.
        if (root == null) return 0;

        // Append current digit: shift left in base-10 and add current node's value.
        sum = sum * 10 + root.val;

        // If this is a leaf, the formed number is complete; return it.
        if (root.left == null && root.right == null) return sum;

        // Otherwise, continue exploring both subtrees and aggregate their contributions.
        return helper(root.left, sum) + helper(root.right, sum);
    }
}
