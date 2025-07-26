package GFG;

public class da80y {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                level.add(curr.data);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            ans.add(level);
        }

        return ans;
    }
}
