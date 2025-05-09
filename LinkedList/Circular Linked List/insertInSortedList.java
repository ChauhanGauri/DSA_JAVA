/*given a pointer to the head node of a sorted circular linked list, insert an element in it.*/
class LinkList {
    int data;
    LinkList next;

    LinkList(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {
    static LinkList insertSorted(LinkList head, int data) {
        LinkList newNode = new LinkList(data);
        
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        LinkList curr = head;

        // Insert before head (smallest element)
        if (data <= head.data) {
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
            return newNode; // New head
        }

        // Insert in sorted position
        while (curr.next != head && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

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
}

public class Main {
    public static void main(String[] args) {
        LinkList head = null;

        // Insert elements in sorted order
        head = Result.insertSorted(head, 30);
        head = Result.insertSorted(head, 10);
        head = Result.insertSorted(head, 20);
        head = Result.insertSorted(head, 5);
        head = Result.insertSorted(head, 40);

        System.out.println("Sorted Circular Linked List:");
        Result.printList(head);
    }
}
