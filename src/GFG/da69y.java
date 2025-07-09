package GFG;

public class da69y {
    // Node class must be static to use in static methods
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Utility to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Remove any leading zeros (except allow single zero node)
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }

    // Main addition method
    static Node addTwoLists(Node num1, Node num2) {
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);

        num1 = reverse(num1);
        num2 = reverse(num2);

        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;

        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;
        }

        Node result = reverse(dummy.next);
        result = trimLeadingZeros(result);
        return result;
    }

    // Helper to print the linked list (for testing)
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        // Construct test number list1: 0 -> 0 -> 6 -> 3 (represents 63)
        Node a = new Node(0);
        a.next = new Node(0);
        a.next.next = new Node(6);
        a.next.next.next = new Node(3);

        // list2: 0 -> 7 (represents 7)
        Node b = new Node(0);
        b.next = new Node(7);

        Node sum = addTwoLists(a, b);
        printList(sum);  // Expected output: 7 -> 0
    }
}
