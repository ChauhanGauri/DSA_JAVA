/*-------Notes----------
  The task is to rotate a doubly linked list by k positions to the right. In a right rotation, the last k nodes move to the front of the list
  while maintaining their relative order.
  For example, if we have a list 1↔2↔3↔4↔5 and k=2, the result should be 4↔5↔1↔2↔3.

  Edge Case: If the list is empty (head == null), there's nothing to rotate
             If there's only one node (head.next == null), rotation has no effect
             If k=0, no rotation is needed
  Step1: traverse the list to calculate its length
  Step2: Normalize k
  Step3: Find the New Breaking Point (new head will be at position (length-k+1))
  Step4: Rearrange the List (The node after our new tail becomes the new head,connect the original tail to the original head)
  
  */
/* Class representing a node in a doubly linked list*/
class LinkList {
    int data;
    LinkList next;
    LinkList prev;
    
    public LinkList(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

static LinkList rotateByK(LinkList head, int k) {
    // Handle edge cases
    if (head == null || head.next == null || k == 0) {
        return head;
    }
    
    // Find length of the list and the last node
    LinkList current = head;
    int length = 1;
    while (current.next != null) {
        current = current.next;
        length++;
    }
    LinkList tail = current;
    
    // Normalize k to be within the range of list length
    k = k % length;
    if (k == 0) {
        return head; // No rotation needed
    }
    
    // For right rotation, we need to find the (length-k)th node
    LinkList newTail = head;
    for (int i = 1; i < length - k; i++) {
        newTail = newTail.next;
    }
    
    // The node after newTail becomes the new head
    LinkList newHead = newTail.next;
    
    // Break the list at newTail
    newTail.next = null;
    newHead.prev = null;
    
    // Connect the original tail to the original head
    tail.next = head;
    head.prev = tail;
    
    return newHead;
}

/**
 * Utility method to print the doubly linked list
 */
static void printList(LinkList head) {
    LinkList current = head;
    System.out.print("List: ");
    while (current != null) {
        System.out.print(current.data);
        if (current.next != null) {
            System.out.print(" ↔ ");
        }
        current = current.next;
    }
    System.out.println();
}

/**
 * Example usage of the rotateByK function
 */
public static void main(String[] args) {
    // Create a sample list: 1 ↔ 2 ↔ 3 ↔ 4 ↔ 5
    LinkList head = new LinkList(1);
    LinkList node2 = new LinkList(2);
    LinkList node3 = new LinkList(3);
    LinkList node4 = new LinkList(4);
    LinkList node5 = new LinkList(5);
    
    // Connect nodes in both directions
    head.next = node2;
    node2.prev = head;
    
    node2.next = node3;
    node3.prev = node2;
    
    node3.next = node4;
    node4.prev = node3;
    
    node4.next = node5;
    node5.prev = node4;
    
    // Print original list
    System.out.println("Original list:");
    printList(head);
    
    // Rotate list by 2 positions
    int k = 2;
    System.out.println("Rotating list by " + k + " positions:");
    head = rotateByK(head, k);
    
    // Print rotated list
    System.out.println("Rotated list:");
    printList(head);
}
