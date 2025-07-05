package GFG;

public class da66y {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null||k==0||head.next==null)return head;
        Node tail=head;
        int h=1;
        while(tail.next!=null){
            tail=tail.next;
            h++;
        }
        tail.next=head;
        k=k%h;
        if(k==0){
            tail.next=null;
            return head;
        }
        Node newTail=head;
        for(int i=1;i<k;i++){
            newTail=newTail.next;
        }
        Node newhead=newTail.next;
        newTail.next=null;
        return head;


    }
}
