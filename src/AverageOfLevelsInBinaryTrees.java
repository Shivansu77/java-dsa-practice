import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AverageOfLevelsInBinaryTrees {
    public List<double> averageOfLevels(TreeNode root){
        List<double>result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int LevelSize=queue.size();
            double doubleSum=0;
            for(int i=0;i<LevelSize;i++){
                TreeNode currentNode=queue.poll();
                doubleSum+=currentNode.val;
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                double average=doubleSum/LevelSize;
                result.add(average);
            }
        }

        return result;
    }
}
