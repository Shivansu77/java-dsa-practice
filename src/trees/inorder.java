package trees;

import java.util.ArrayList;

class InorderTraversal {
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer>list=new ArrayList<>();
        helper(root,list);
        return list;

    }
    public void helper(Node root, ArrayList<Integer>list){
        if(root==null)return;
        helper(root.left,list);
        list.add(root.data);
        helper(root.right,list);
    }
}
