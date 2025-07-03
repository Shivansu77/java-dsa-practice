// Using the custom TreeNode class defined in TreeNode.java

public class cousinsTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (xx != null && yy != null) &&
                (level(root, xx, 0) == level(root, yy, 0)) &&
                (!isSibling(root, xx, yy));
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right == y) ||
                (node.right == x && node.left == y) || // Fixed incorrect condition
                isSibling(node.right, x, y) ||
                isSibling(node.left, x, y));
    }

    int level(TreeNode node, TreeNode x, int lev) { // Fixed incorrect parameter reference
        if (node == null) {
            return -1; // Use -1 to indicate not found
        }
        if (node == x) {
            return lev;
        }
        int l = level(node.left, x, lev + 1);
        if (l != -1) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }
}
