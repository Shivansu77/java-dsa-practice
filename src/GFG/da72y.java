package GFG;

public class da72y {
    public static Node findFirstNode(Node head) {
        // code here
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }

        if(fast==null || fast.next==null)return null;

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
