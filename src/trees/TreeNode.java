package trees;

/**
 * Simple binary tree node used across tree-related algorithms.
 * 'val' holds the node's integer value, and 'left'/'right' point to child nodes.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
