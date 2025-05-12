class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLinkedList {
    Node front, rear; // Front and rear pointers

    // Method to add an element to the queue
    void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) { // If queue is empty, set both front and rear to new node
            front = rear = newNode;
        } else {
            rear.next = newNode; // Link new node at the end
            rear = newNode; // Update rear pointer
        }
    }

    // Method to remove an element from the queue
    void dequeue() {
        if (front == null) { // Check if the queue is empty
            System.out.println("Queue is empty!");
            return;
        }
        front = front.next; // Move front pointer to the next node
        if (front == null) rear = null; // If queue becomes empty, set rear to null
    }

    // Method to display the queue elements
    void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList(); // Create queue object

        queue.enqueue(10); // Add elements to the queue
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // Display queue elements

        queue.dequeue(); // Remove an element
        queue.display(); // Display queue after dequeue

        queue.dequeue(); // Remove another element
        queue.display();
        queue.enqueue(10);
        queue.display();
    }
}
