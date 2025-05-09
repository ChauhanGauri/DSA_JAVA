/*----------Notes---------------
given a pointer to the head node of a circular linked list with even number of nodes, cut it from middle and return the two lists as two 
separate circular linked lists.

Edge Case: If the list is empty or contains only one node, there's nothing to split — return null.
Step1: Use Floyd’s Cycle (slow-fast pointer) to find the middle of the circular list.(slow will be at the mid-point)
Step2: slow.next becomes newHead od second list
Step3: Cut the list into two halves by connecting the middle node back to the head.
Step4: Traverse from newHead until we find the node pointing to head, make it point to newHead.
*/
class LinkList {
    int data;
    LinkList next;

    LinkList(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {
    static LinkList listCut(LinkList head) {
        if (head == null || head.next == head) {
            return null;
        }

        LinkList slow = head, fast = head;

        // Use Floyd’s Cycle approach to find the midpoint
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Second half starts after the midpoint
        LinkList newHead = slow.next;

        // Close the first half
        slow.next = head;

        // Close the second half
        LinkList temp = newHead;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newHead;

        return newHead; // Head of second half
    }

    // Helper method to print a circular linked list
    static void printList(LinkList head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        LinkList curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    // Optional: method to insert at end to create circular list for testing
    static LinkList insertEnd(LinkList head, int data) {
        LinkList newNode = new LinkList(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        LinkList temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        return head;
    }

    // Main for testing
    public static void main(String[] args) {
        LinkList head = null;
        head = insertEnd(head, 1);
        head = insertEnd(head, 2);
        head = insertEnd(head, 3);
        head = insertEnd(head, 4);
        head = insertEnd(head, 5);

        System.out.print("Original list: ");
        printList(head);

        LinkList secondHalf = listCut(head);

        System.out.print("First half: ");
        printList(head);

        System.out.print("Second half: ");
        printList(secondHalf);
    }
}
