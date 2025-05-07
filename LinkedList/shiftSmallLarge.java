class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListManipulation {

    // Function to move smallest to head and largest to tail
    static Node shiftSmallLarge(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node smallest = head;
        Node largest = head;
        Node curr = head;

        // Find smallest and largest nodes
        while (curr != null) {
            if (curr.data < smallest.data) {
                smallest = curr;
            }
            if (curr.data > largest.data) {
                largest = curr;
            }
            curr = curr.next;
        }

        // Move smallest to front
        if (head != smallest) {
            curr = head;
            while (curr.next != smallest) {
                curr = curr.next;
            }
            curr.next = smallest.next;
            smallest.next = head;
            head = smallest;
        }

        // Move largest to end
        if (largest.next != null) { // only move if not already at end
            curr = head;
            while (curr.next != largest) {
                curr = curr.next;
            }
            curr.next = largest.next;

            // Move to the end of the list
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }

            tail.next = largest;
            largest.next = null;
        }

        return head;
    }

    // Function to create linked list from array
    static Node buildList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Function to print linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main function to test
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 3};
        Node head = buildList(arr);
        System.out.println("Original list:");
        printList(head);

        head = shiftSmallLarge(head);
        System.out.println("Modified list:");
        printList(head);
    }
}
