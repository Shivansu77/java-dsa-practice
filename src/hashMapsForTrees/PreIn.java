package hashMapsForTrees;

import java.util.*;

 class TreeBuilder {

    // Binary tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Build tree from preorder and inorder
    static class PreIn {
        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            int[] index = {0}; // mutable index
            return helper(preOrder, inOrder, 0, preOrder.length - 1, map, index);
        }

        private TreeNode helper(int[] preOrder, int[] inOrder, int left, int right,
                                HashMap<Integer, Integer> map, int[] index) {
            if (left > right) return null;

            int current = preOrder[index[0]++];
            TreeNode node = new TreeNode(current);

            int inIndex = map.get(current);

            node.left = helper(preOrder, inOrder, left, inIndex - 1, map, index);
            node.right = helper(preOrder, inOrder, inIndex + 1, right, map, index);

            return node;
        }
    }

    // Level-order traversal to visualize tree structure
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("Level Order: ");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Main method to run the test
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        PreIn builder = new PreIn();
        TreeNode root = builder.buildTree(preOrder, inOrder);

        printLevelOrder(root);
    }
}
