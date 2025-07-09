package hashMapsForTrees;

public class twosum {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer>set=new HashSet<>();
        return helper(root,k,set);
    }
    public boolean helper(TreeNode root,int k,HashSet<Integer>set){
        if(root==null)return false;
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
