/*----------Notes--------------------
     The aim is to detect a loop in a linked list using Floyd's Cycle Detection Algorithm.
     If a loop is present, returns the length of the loop. Otherwise, returns 0.
     Steps:
     1. Use two pointers (fast and slow). Move fast by 2 steps and slow by 1 step.
     2. If fast and slow meet, a loop exists.
     3. To find the loop length:
        - Keep a temporary pointer at the meeting point.
        - Move it until it comes back to the same point, counting steps.*/
  class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {
    static int loopInList(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Loop detected
                int count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        return 0; // No loop
    }

    // Helper method to create a linked list with a loop for testing
    static Node createLoopedList(int[] values, int loopStartIndex) {
        Node head = new Node(values[0]);
        Node curr = head;
        Node loopStartNode = null;

        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
            if (i == loopStartIndex) {
                loopStartNode = curr;
            }
        }

        // Creating the loop
        if (loopStartNode != null) {
            curr.next = loopStartNode;
        }

        return head;
    }

    // Main method to test the loop detection
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        int loopStartIndex = 2; // 0-based index for node to loop back to

        Node head = createLoopedList(values, loopStartIndex);

        int loopLength = loopInList(head);
        if (loopLength > 0) {
            System.out.println("Loop detected with length: " + loopLength);
        } else {
            System.out.println("No loop detected.");
        }
    }
}
