package GFG;

public class da70y {
    public Node cloneLinkedList(Node head) {
        if(head==null)return null;

        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.data);
            copy.next=curr.next;
            curr.next=copy;
            curr=copy.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        Node dummy=new Node(0);
        Node copyCurr=dummy;
        curr=head;
        while(curr!=null){
            copyCurr.next=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        return dummy.next;
    }
}
