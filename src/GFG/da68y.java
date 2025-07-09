package GFG;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class da68y {

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node prev = null;
        Node nextNode = null;
        Node node = head;
        int c = 0;

        // Reverse k nodes
        while (node != null && c < k) {
            nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
            c++;
        }

        // Recursively reverse the rest
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        return prev; // New head of the reversed segment
    }

    // Utility method to print the linked list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Utility method to create a linked list from an array
    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] values = {3, 5, 4, 7, 7, 9, 8, 3, 1, 8, 6};
        int k = 3;

        Node head = createList(values);
        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("List after reversing in groups of " + k + ":");
        printList(head);
    }
}
