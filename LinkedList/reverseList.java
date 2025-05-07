class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {

    // Return the new head of reversed list
    static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Helper to build a linked list from an array
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

    // Helper to print a linked list
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
        int[] values = {1, 2, 3, 4, 5};
        Node head = buildList(values);

        System.out.println("Original List:");
        printList(head);

        Node reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
