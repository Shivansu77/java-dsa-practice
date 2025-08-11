package trees;

import java.util.ArrayList;

public class correctBst {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        helper(root,list);
        return helper2(list);
    }
    void helper(Node root,ArrayList<Integer>list){
        if(root==null)return;
        helper(root.left,list);
        list.add(root.data);
        helper(root.right,list);
    }
    boolean helper2(ArrayList<Integer>list){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1))return false;
        }
        return true;
    }
}
