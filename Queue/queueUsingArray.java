class QueueArray {
    int SIZE = 5; // Maximum size of the queue
    int[] queue = new int[SIZE]; // Array to store queue elements
    int front = -1, rear = -1; // Front and rear pointers

    // Method to add an element to the queue
    void enqueue(int value) {
        if (rear == SIZE - 1) // Check if the queue is full
            System.out.println("Queue is full!");
        else {
            if (front == -1) front = 0; // Set front to 0 if queue was empty
            queue[++rear] = value; // Increment rear and add the value
        }
    }

    // Method to remove an element from the queue
    void dequeue() {
        if (front == -1 || front > rear) // Check if the queue is empty
            System.out.println("Queue is empty!");
        else
            front++; // Increment front to remove an element
    }

    // Method to display the queue elements
    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(); // Create queue object

        queue.enqueue(10); // Add elements to the queue
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // Display queue elements

        queue.dequeue(); // Remove an element
        queue.display(); // Display queue after dequeue

        queue.enqueue(60); // Attempt to add another element (should show "Queue is full!")
    }
}
