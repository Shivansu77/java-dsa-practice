// Using the custom TreeNode class defined in TreeNode.java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTrees {
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double levelSum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            // Calculate average after processing all nodes at this level
            double average = levelSum / levelSize;
            result.add(average);
        }

        return result;
    }
}
