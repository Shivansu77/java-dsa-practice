package trees;

/**
 * Alternative binary tree node structure used by some older/other tree problems in this project.
 * Similar to TreeNode but uses field name 'data' instead of 'val'.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
}
