/*----------Notes-------------
Given a pointer to the head node of a doubly linked list, rearrange the nodes of list such that all even positioned nodes are shifted before 
odd positioned nodes while keeping their relative order same as in the original list. 
 Step1: Create 4 pointers - oddHead and oddTail to track the first and last nodes of the odd-positioned list
                            evenHead and evenTail to track the first and last nodes of the even-positioned list
 Step2: traverse the original list with the current pointer, keeping track of position:
        For odd positions (1st, 3rd, 5th...), it adds the node to the odd list
        For even positions (2nd, 4th, 6th...), it adds the node to the even list
 Step3: After separating the lists, ensure both lists are properly terminated by setting the next pointer of both tails to null.
 Step4: combines the lists by connecting the last node of the even list to the first node of the odd list, and return the head of the even list
        as the new starting point.
 */

class Node {
    int val;
    Node next;
    Node prev;
    
    // Constructor
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedListRearrangement {
    public static Node rearrangeList(Node head) {
        // Handle empty list or single node list
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize pointers for odd and even lists
        Node oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        Node current = head;
        int pos = 1;
        
        // Separate the nodes into odd and even positions
        while (current != null) {
            // Save the next node before modifying current's pointers
            Node next = current.next;
            
            if (pos % 2 == 1) {
                // Odd position node
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    current.prev = oddTail;
                    oddTail = current;
                }
            } else {
                // Even position node
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    current.prev = evenTail;
                    evenTail = current;
                }
            }
            
            // Move to the next node
            current = next;
            pos++;
        }
        
        // Terminate both lists
        if (oddTail != null) {
            oddTail.next = null;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        
        // Join even list followed by odd list
        if (evenHead == null) {
            return oddHead; // Only odd nodes exist
        }
        
        evenTail.next = oddHead;
        if (oddHead != null) {
            oddHead.prev = evenTail;
        }
        
        return evenHead; // New head is the head of the even list
    }
    
    /*
      Utility method to print a doubly linked list
    */
    public static void printList(Node head) {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    /*
      Utility method to create a sample doubly linked list
     */
    public static Node createSampleList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        Node head = new Node(values[0]);
        Node current = head;
        
        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        
        return head;
    }
    
    /*
      Main method to demonstrate the rearrangement
     */
    public static void main(String[] args) {
        // Create a sample list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        int[] values = {1, 2, 3, 4, 5};
        Node head = createSampleList(values);
        
        System.out.println("Original List:");
        printList(head);
        
        // Rearrange the list
        Node rearrangedHead = rearrangeList(head);
        
        System.out.println("Rearranged List (even positions followed by odd positions):");
        printList(rearrangedHead);
        
        // Test with even number of nodes: 1 <-> 2 <-> 3 <-> 4
        int[] values2 = {1, 2, 3, 4};
        Node head2 = createSampleList(values2);
        
        System.out.println("\nOriginal List 2:");
        printList(head2);
        
        // Rearrange the list
        Node rearrangedHead2 = rearrangeList(head2);
        
        System.out.println("Rearranged List 2 (even positions followed by odd positions):");
        printList(rearrangedHead2);
    }
}
