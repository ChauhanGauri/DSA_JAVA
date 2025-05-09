/*-----------Notes--------------
  In circular list the last node points to the first node creating a loop of nodes. Now, given a pointer to the head node of a linked list,
  find out if it is circular or not.

  Step1: Use Floyd's Cycle Detection algorithm (fast and slow pointers)
         is fast and slow pointers meet means cycle exists
  Step2: Check whethe the cycle is linked from tail to head only
         for this set the check pointer equal to slow which will be the middle of the list if cycle exists, and iterate it till head (circular)
         or till back to slow(not circular)
  
  
*/
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedListChecker {

    // Function to check if the linked list is circular
    static int isCircular(Node head) {
        if (head == null) {
            return 1; // Empty list is considered circular
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected, now check if loop connects to head
                Node check = slow;
                while (check.next != slow && check.next != head) {
                    check = check.next;
                }
                return (check.next == head) ? 1 : 0;
            }
        }
        return 0; // No loop found
    }

    // Sample test
    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Make it circular
        head.next.next.next.next = head; // Comment this line to make it non-circular

        int result = isCircular(head);

        if (result == 1) {
            System.out.println("The linked list is circular.");
        } else {
            System.out.println("The linked list is not circular.");
        }
    }
}
