/*-----------Notes to understand logic-------------
 1. If the original list is empty, return null.
 2. Create the head of the new list using the data from the original head.
 3. Use two pointers:
    - tempOriginal: to traverse the original list.
    - tempCopy: to build the new list.
 4. For each node in the original list:
    - Create a new node with the same data.
    - Link it to the end of the copied list.
 5. Return the head of the newly copied list.*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCopy {

    // Function to copy the linked list
    static Node copyList(Node head) {
        if (head == null) {
            return null;
        }

        Node L2 = new Node(head.data); // First node in the copied list
        Node tempOriginal = head.next;
        Node tempCopy = L2;

        while (tempOriginal != null) {
            Node newNode = new Node(tempOriginal.data);
            tempCopy.next = newNode;
            tempCopy = tempCopy.next;
            tempOriginal = tempOriginal.next;
        }

        return L2;
    }

    // Helper to build list from array
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

    // Helper to print the linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40};
        Node originalList = buildList(values);

        System.out.println("Original List:");
        printList(originalList);

        Node copiedList = copyList(originalList);

        System.out.println("Copied List:");
        printList(copiedList);
    }
}
