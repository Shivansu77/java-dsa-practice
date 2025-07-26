package GFG;

public class da81y {
    int height(Node node) {
        // code here
        if(node==null)return -1;
        int l=height(node.left);
        int r=height(node.right);
        return 1+Math.max(l,r);
    }
}
