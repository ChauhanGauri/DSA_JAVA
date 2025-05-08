/*---------Notes-------------
  **Do not swap data, swap actual nodes.**
  Edge Case: If x == y, no need to swap, If the list is empty (head == null), return head.
  Step1: Traverse the list to find nodes containing data x and y.Store references in nodeX and nodeY.
         If any node not found, return original head.
  Step2: Update previous nodes’ next pointers if they exist
  Step3: Update next nodes’ prev pointers if they exist 
  Step4: Swap next and prev pointers of nodeX and nodeY.*/
class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Function to add node at the end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    // Function to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to swap nodes with values x and y
    public Node swapNodes(Node head, int x, int y) {
        if (x == y || head == null) {
            return head;
        }

        Node nodeX = null, nodeY = null, current = head;

        while (current != null) {
            if (current.data == x) {
                nodeX = current;
            } else if (current.data == y) {
                nodeY = current;
            }
            current = current.next;

            if (nodeX != null && nodeY != null) {
                break;
            }
        }

        if (nodeX == null || nodeY == null) {
            return head; // Either x or y not found
        }

        // Adjust previous pointers
        if (nodeX.prev != null) {
            nodeX.prev.next = nodeY;
        } else {
            head = nodeY;
        }

        if (nodeY.prev != null) {
            nodeY.prev.next = nodeX;
        } else {
            head = nodeX;
        }

        // Adjust next pointers
        if (nodeX.next != null) {
            nodeX.next.prev = nodeY;
        }

        if (nodeY.next != null) {
            nodeY.next.prev = nodeX;
        }

        // Swap next pointers
        Node tempNext = nodeX.next;
        nodeX.next = nodeY.next;
        nodeY.next = tempNext;

        // Swap prev pointers
        Node tempPrev = nodeX.prev;
        nodeX.prev = nodeY.prev;
        nodeY.prev = tempPrev;

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.println("Original list:");
        list.printList();

        list.head = list.swapNodes(list.head, 20, 40);

        System.out.println("List after swapping 20 and 40:");
        list.printList();
    }
}
