package trees;

import java.util.ArrayList;

/**
 * Checks whether a binary tree is a valid Binary Search Tree (BST).
 * Property: Inorder traversal of a BST yields a non-decreasing sequence.
 */
class CorrectBst {
    /**
     * Returns true if the tree rooted at 'root' is a BST.
     */
    boolean isBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        // Collect inorder traversal values
        helper(root, list);
        // Verify non-decreasing order
        return helper2(list);
    }

    /** Inorder traversal to collect node values. */
    void helper(Node root, ArrayList<Integer> list){
        if (root == null) return;
        helper(root.left, list);
        list.add(root.data);
        helper(root.right, list);
    }

    /** Verify that the array is non-decreasing. */
    boolean helper2(ArrayList<Integer> list){
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }
}
