import java.util.*;

public class countPathsbacktr {
    List<List<Integer>> countPath(Node node,int sum){
        List<List<Integer>>paths=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        helper(node,sum,path);
        return paths;
    }
    void helper(Node node,int sum,List<Integer>path,List<List<Integer>>paths){
        if(node==null){
            return 0;
        }
        path.add(node.val);
        if(node.val==sum && node.left=null && node.right==null){
            paths.add(new ArrayList<>(path));
        }else{
            helper(node.left,sum-node.val,paths);
            helper(node.right,sum-node.val,paths);
        }

        //backTrack
        path.remove(path.size()-1);
        return count;


    }
}
