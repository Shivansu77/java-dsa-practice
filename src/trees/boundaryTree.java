package trees;

import java.util.ArrayList;

public class boundaryTree {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>res=new ArrayList<>();
        if(root==null)return res;
        if(!isLeaf(root)) res.add(root.data);

        Node curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr))res.add(curr.data);
            if(curr.left!=null)curr=curr.left;
            else curr=curr.right;
        }

        addLeaves(root,res);
        ArrayList<Integer>temp=new ArrayList<>();
        curr=root.right;
        while(curr!=null){
            if(!isLeaf(curr))temp.add(curr.data);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;

        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
        return res;
    }
    private boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    private void addLeaves(Node node,ArrayList<Integer>res){
        if(node==null)return;
        if(isLeaf(node)){
            res.add(node.data);
            return;
        }
        addLeaves(node.left,res);
        addLeaves(node.right,res);

    }
}
