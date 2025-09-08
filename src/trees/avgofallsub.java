package trees;

public class avgofallsub {
    static double max;
    public static double maxSubtreeAverage(TreeNode<Integer> root) {
        // Write your code here.
        max = Double.NEGATIVE_INFINITY;
        dfs(root);
        return max;

    }
    public static int[] dfs(TreeNode<Integer> root){
        if(root==null)return new int[]{0,0};

        int []left=dfs(root.left);
        int []right=dfs(root.right);

        int sum=left[0]+right[0]+root.data;
        int count=1+right[1]+left[1];

        double avg=(double)sum/count;
        max=Math.max(avg,max);
        return new int[]{sum,count};

    }
}
