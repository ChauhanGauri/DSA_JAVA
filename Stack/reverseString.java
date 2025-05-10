/*-----Notes---------
  Step1: Push all characters of string to stack
  Step2: Create a StringBuilder variable 
  Step3: append characters from stack to variable*/
  class CQStack {
    private char[] stack;
    private int top;
    private int capacity;

    // Constructor
    public CQStack(int size) {
        capacity = size;
        stack = new char[capacity];
        top = -1;
    }

    // Push character onto stack
    public void push(char ch) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = ch;
    }

    // Pop character from stack
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return '\0'; // null character
        }
        return stack[top--];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

public class ReverseStringUsingStack {

    // Function to reverse string using stack
    static String reverseString(CQStack s, String st) {
        for (int i = 0; i < st.length(); i++) {
            s.push(st.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }

        return result.toString();
    }

    // Main method to test
    public static void main(String[] args) {
        String input = "HelloWorld";
        CQStack stack = new CQStack(input.length());
        String reversed = reverseString(stack, input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
