package trees;

public class buildTree { public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(inorder.length==0)return null;
    int pre=preorder[0];
    int index=-1;
    for(int i=0;i<inorder.length;i++){
        if(inorder[i]==pre){
            index=i;
            break;
        }
    }
    if (index == -1) return null;
    TreeNode root=new TreeNode(pre);
    root.left=buildTree(Arrays.copyOfRange(preorder, 1, index+1),Arrays.copyOfRange(inorder, 0, index)
    );
    root.right=buildTree( Arrays.copyOfRange(preorder, index+1,preorder.length),Arrays.copyOfRange(inorder, index+1, inorder.length));
    return root;
}
}
