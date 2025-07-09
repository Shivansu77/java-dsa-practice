public class kthSmallest {
    int count = 0;
    int result = 0;

    public int kthSmallest1(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode node, int k) {
        if (node == null) return;

        helper(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        helper(node.right, k);
    }

}
