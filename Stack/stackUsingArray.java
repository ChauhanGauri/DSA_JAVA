class CQStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public CQStack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + j);
            return;
        }
        stackArray[++top] = j;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
public class Main {
    public static void main(String[] args) {
        CQStack stack = new CQStack(5); // create a stack of size 5

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking at top element
        System.out.println("Top element: " + stack.peek()); // Should print 30

        // Popping elements
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        // Checking if stack is empty
        System.out.println("Is empty? " + stack.isEmpty()); // false

        // Pushing more elements
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70); // Should show stack is full

        // Final stack status
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Trying to pop from empty stack
        stack.pop(); // Should show stack is empty
    }
}
