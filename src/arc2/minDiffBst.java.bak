public class minDiffBst {
    TreeNode prev=null;
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        helper(root);
        return min;

    }
    //basically we are using inOrder;
    public void helper(TreeNode root){
        if(root==null){
            return ;
        }
        helper(root.left);
        if(prev!=null){
            min=Math.min(root.val-prev.val,min);
        }
        prev=root;
        helper(root.right);

    }
}
