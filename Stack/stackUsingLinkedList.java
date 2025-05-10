class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Stack{
    private Node top;
    public void push(int x){
        Node newNode= new Node(x);
        newNode.next=top;
        top=newNode;
        System.out.println("pushed: "+x);
    }
    public int pop(){
        if (top==null){
            System.out.println("Stack underflow");
            return -1;
        }
        int data=top.data;
        top=top.next;
        System.out.println("popped: "+data);
        return data;
    }
    public int peek(){
        if(top==null){
            System.out.println("stack is empty");
            return -1;
        }
        return top.data;
    }
    public static void main(String args[]){
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: "+stack.peek());
        stack.pop();
        System.out.println("peek after pop: "+stack.peek());
    }
}
