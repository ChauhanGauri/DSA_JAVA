/*----------Notes------------
 The aim is to determine if the linked list is a palindrome.
 Steps:
 1. Use the slow and fast pointer technique to find the middle of the list.
 2. Reverse the second half of the list starting from the middle node.
 3. Use two pointers to traverse and compare the first half and the reversed second half.
    - If all corresponding elements are equal, the list is a palindrome.
    - If any mismatch is found, return false (0). */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {

    // Function to reverse a linked list
    static Node reverseList(Node head) {
        Node curr = head, prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static int checkPalindrome(Node head) {
        if (head == null || head.next == null) {
            return 1;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow);
        Node temp1 = head;
        Node temp2 = secondHalf;

        // Compare first and second half
        while (temp2 != null) {
            if (temp1.data != temp2.data) {
                return 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return 1;
    }

    // Helper method to build list from array
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

    // Helper method to print a linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 2, 1}; 
        Node head = buildList(values);

        System.out.println("Linked List:");
        printList(head);

        int result = checkPalindrome(head);
        if (result == 1) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
