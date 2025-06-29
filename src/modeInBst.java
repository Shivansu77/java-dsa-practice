public class modeInBst {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        TreeNode prev=null;
        int count=1;
        int max=0;
        public int[] findMode(TreeNode root) {
            if(root==null) return new int[0];
            List<Integer>modes=new ArrayList<>();
            helper(root,modes);
            int []arr=new int[modes.size()];
            for(int i=0;i<modes.size();i++){
                arr[i]=modes.get(i);
            }
            return arr;

        }
        private void helper(TreeNode root,List<Integer>modes){
            if(root==null)return ;
            helper(root.left,modes);
            if(prev!=null){
                if(root.val==prev.val){
                    count++;
                }else{
                    count=1;
                }
            }
            if(count>max){
                max=count;
                modes.clear();
                modes.add(root.val);
            }else if(count==max){
                modes.add(root.val);
            }
        }
}
