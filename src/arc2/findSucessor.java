// Using the custom TreeNode class defined in TreeNode.java
import java.util.LinkedList;
import java.util.Queue;

public class findSucessor {
    public TreeNode findsuccessor(TreeNode root,int key){
        if(root==null){
            return null;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode=queue.poll();
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
            if(currentNode.val==key){
                break;
            }

        }
        return queue.isEmpty() ? null : queue.peek();
    }
}
