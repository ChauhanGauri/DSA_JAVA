/*Implement the stack using array which supports, push, pop and getMin functions with constant time complexity.*/
class MinStack {
    private int[] stackArray = new int[100];
    private int[] minValues = new int[100];
    private int top = -1;
    private int minTop = -1;

    boolean isFull() {
        return top == stackArray.length - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int item) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }

        stackArray[++top] = item;

        if (minTop == -1 || item <= minValues[minTop]) {
            minValues[++minTop] = item;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        int value = stackArray[top--];

        if (value == minValues[minTop]) {
            minTop--;
        }

        return value;
    }

    int getMin() {
        if (isEmpty() || minTop == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        return minValues[minTop];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stackArray[top];
    }
}

public class MinStackDemo {
    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(4);
        s.push(2);
        s.push(8);
        s.push(1);

        System.out.println("Top: " + s.peek());        // Output: 1
        System.out.println("Min: " + s.getMin());      // Output: 1

        s.pop(); // removes 1
        System.out.println("Top: " + s.peek());        // Output: 8
        System.out.println("Min: " + s.getMin());      // Output: 2

        s.pop(); // removes 8
        System.out.println("Top: " + s.peek());        // Output: 2
        System.out.println("Min: " + s.getMin());      // Output: 2
    }
}
