package GFG;

public class da65y {
    Node reverseList(Node head) {
        // code here
        Node node=head;
        Node prev=null;
        while(node!=null){
            Node nextNode=node.next;
            node.next=prev;
            prev=node;
            node=nextNode;
        }
        return prev;
    }
}
