/*-------Notes-----------
  Given a pointer to the head node of a circular linked list, delete the nodes from beginning or end.*/
class LinkList {
    int data;
    LinkList next;

    LinkList(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {

    // Delete from beginning
    static LinkList deleteBeg(LinkList head) {
        if (head == null) return null;               // Empty list
        if (head.next == head) return null;          // Only one node

        LinkList temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;                       // Last node points to second node
        return head.next;                            // Return new head
    }

    // Delete from end
    static LinkList deleteEnd(LinkList head) {
        if (head == null) return null;               // Empty list
        if (head.next == head) return null;          // Only one node

        LinkList temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;                            // Second last node points to head
        return head;
    }

    // Utility to print circular linked list
    static void printList(LinkList head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        LinkList temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // Manual list creation for testing
        LinkList head = new LinkList(10);
        LinkList second = new LinkList(20);
        LinkList third = new LinkList(30);
        head.next = second;
        second.next = third;
        third.next = head; // Circular link

        System.out.println("Original List:");
        printList(head);

        head = deleteBeg(head);
        System.out.println("After deleting from beginning:");
        printList(head);

        head = deleteEnd(head);
        System.out.println("After deleting from end:");
        printList(head);
    }
}
