package trees;

public class pathsumiii {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer>path=new ArrayList<>();
        return helper(root,targetSum,path);
    }
    public int helper(TreeNode node,int targetSum,List<Integer>path){
        if(node==null)return 0;
        path.add(node.val);
        int c=0;
        long pathSoFar = 0L;
        for(int i=path.size()-1;i>=0;i--){
            pathSoFar+=path.get(i);
            if(pathSoFar==targetSum)c++;
        }
        c+=helper(node.left,targetSum,path);
        c+=helper(node.right,targetSum,path);
        path.remove(path.size()-1);
        return c;

    }
}
