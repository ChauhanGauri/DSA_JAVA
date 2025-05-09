class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {
    static int countNodes(Node head) {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node temp = head;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Manually create circular linked list: 10 -> 20 -> 30 -> 10 ...
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head.next = second;
        second.next = third;
        third.next = head; // Make it circular

        // Count nodes
        int totalNodes = Result.countNodes(head);
        System.out.println("Total nodes in circular linked list: " + totalNodes);
    }
}
