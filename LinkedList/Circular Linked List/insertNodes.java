/*---------Notes--------------
  Given a pointer to the head node of a circular linked list, insert the new nodes at beginning or end.*/
class LinkList {
    int data;
    LinkList next;

    LinkList(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {

    // Insert at the beginning of circular linked list
    static LinkList insertBeg(LinkList head, int data) {
        LinkList newHead = new LinkList(data);
        if (head == null) {
            newHead.next = newHead;
            return newHead;
        }

        LinkList temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newHead;
        newHead.next = head;
        return newHead;
    }

    // Insert at the end of circular linked list
    static LinkList insertEnd(LinkList head, int data) {
        LinkList newTail = new LinkList(data);
        if (head == null) {
            newTail.next = newTail;
            return newTail;
        }

        LinkList temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTail;
        newTail.next = head;
        return head;  // head doesn't change on end insert
    }

    // Print the circular linked list
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
        LinkList head = null;

        // Insert at beginning
        head = insertBeg(head, 30);
        head = insertBeg(head, 20);
        head = insertBeg(head, 10);

        System.out.println("After insertBeg:");
        printList(head);

        // Insert at end
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);

        System.out.println("After insertEnd:");
        printList(head);
    }
}
