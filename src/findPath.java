public class findPath {
    boolean FindPath(Node node,int []arr){
        if(node==null){
            return arr.length==0;
        }
        return helper(node,arr,0);
    }
    boolean helper(Node node,int []arr,int index){
         if(node==null){
             return false;
         }
         if(index>=arr.length || node.val != arr[index]){
            return false;
         }
         if(node.left==null && node.right!=null && index==arr.length-1){
             return true;
         }
         return helper(node.left,arr,index+1)||helper(node.right,arr,index+1);
    }
}
