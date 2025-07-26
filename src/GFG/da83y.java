package GFG;

public class da83y {
    void mirror(Node node) {
        // Your code here
        if(node==null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
    }
}
