package GFG;

public class da82y {
    int Diameter=0;
    int diameter(Node root) {
        // Your code here
        height(root);
        return Diameter-1;
    }
    public int height(Node root){
        if(root==null)return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        int dia=leftH+rightH+1;
        Diameter=Math.max(Diameter,dia);
        return 1+Math.max(leftH,rightH);
    }
}
