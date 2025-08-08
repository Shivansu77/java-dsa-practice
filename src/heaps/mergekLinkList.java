package heaps;

public class mergekLinkList {
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node>minHeap=new PriorityQueue<>(
                (a,b)->Integer.compare(a.data,b.data));

        for(Node head:arr){
            if(head!=null){
                minHeap.add(head);
            }
        }

        Node dummy=new Node(0);
        Node tail=dummy;
        while(!minHeap.isEmpty()){
            Node smallest=minHeap.poll();
            tail.next=smallest;
            tail=tail.next;
            if(smallest.next!=null){
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }
}
