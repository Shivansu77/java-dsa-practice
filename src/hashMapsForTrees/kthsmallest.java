package hashMapsForTrees;

public class kthsmallest {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        helper(root,minHeap,k);
        int ans=0;
        for(int i=0;i<k;i++){
            ans=minHeap.poll();
        }
        return ans;
    }
    private void helper(TreeNode root, PriorityQueue<Integer>minHeap,int k){
        if(root==null)return;
        helper(root.left,minHeap,k);
        minHeap.offer(root.val);
        helper(root.right,minHeap,k);
    }
}
