package GFG;

public class da84y {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        if(preorder.length==0)return null;
        int r=preorder[0];
        int index=0;
        for(int i=0;i<preorder.length;i++){
            if(inorder[i]==r){
                index=i;
                break;
            }
        }
        Node node=new Node(r);
        node.left=buildTree(Arrays.copyOfRange(inorder,0,index),
                Arrays.copyOfRange(preorder,1,index+1));
        node.right=buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),
                Arrays.copyOfRange(preorder,index+1,preorder.length));
        return node;
    }
}
