package trees;

public class serializeAndDeserial {
    int idx;
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        preorder(root,list);
        return list;

    }
    public void preorder(Node root,ArrayList<Integer>list){
        if(root==null){
            list.add(-1);
            return ;
        }
        list.add(root.data);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        idx=0;
        return build(arr);
        // code here
    }
    public Node build(ArrayList<Integer> arr){
        if(idx>=arr.size())return null;
        int val=arr.get(idx++);
        if(val==-1)return null;
        Node root=new Node(val);
        root.left=build(arr);
        root.right=build(arr);
        return root;
    }
}
