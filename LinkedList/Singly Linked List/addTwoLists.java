/*-------------Notes-------------
  Question : An n-digit number can be expressed using a linked list of n nodes, where each node can be used to represent a digit.
  Now given two numbers represented by two singly linked lists, compute the sum of these numbers, provided that the digits are stored in
  reverse order, such that the digit of 1’s place is at the head of the list.

  Example 1:
  number 254 will be represented as: head -> 4 -> 5 -> 2 -> NULL
  number 71 will be represented as:  head -> 1 -> 7 -> NULL
  Their sum 325 is represented as:   head -> 5 -> 2 -> 3 -> NULL

  Step1: Start with a carry of 0.
  Step2: Traverse both linked lists, adding corresponding digits and the carry.
  Step3: For each pair of digits, calculate the sum:
         -The unit digit of the sum becomes a new node in the result list.
         -The carry is updated (for sums 10 or more).
  Step4: Continue until both lists are finished and there’s no remaining carry.*/
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {
    // Method to add two numbers represented as linked lists
    static Node addListNumbers(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node temp1 = head1, temp2 = head2, current = dummy;
        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;

            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }

            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to create a linked list from an array
    static Node createList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print a linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 3}; // 342
        int[] arr2 = {5, 6, 4}; // 465

        Node head1 = createList(arr1);
        Node head2 = createList(arr2);

        System.out.print("First Number : ");
        printList(head1);

        System.out.print("Second Number: ");
        printList(head2);

        Node result = addListNumbers(head1, head2);

        System.out.print("Sum          : ");
        printList(result); // Expected Output: 7 -> 0 -> 8 (342 + 465 = 807)
    }
}
