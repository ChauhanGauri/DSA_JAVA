/*Step1: Create a stack and dequeue the K elements from queue to push onto stack
  Step2: Create an array and dequeue remaining elements and copy to array
  Step3: Reset queue to be empty and queue elements from stack (pop)
  Step4: Enqueue elements from array */
import java.util.*;
class QueueArray
{
  int SIZE=50;
  int front=-1;
  int rear=-1;
  int array[]=new int[SIZE];

  // Method to add an item to the queue.
  void enqueue(int item)
  {
    if (rear == SIZE)   // Queue is full
      return;
    if(front == -1 && rear == -1){
      front++;
      rear++;
    }
    else
      rear++;
    array[rear] = item;
  }

  // Method to remove an item from queue.
  int dequeue()
  {
    if (front==-1 || front > rear)
    {
      return -1;
    }
    int item = array[front];
    front++;
    return item;
  }  
}

class Main
{

static void reverseKelementsQueue(QueueArray q, int K)
{
    if (q.front==-1 || q.front>q.rear || K<=0){
        return;
    }
    Stack<Integer>stack=new Stack<>();
    int size=q.rear-q.front+1;
    K=Math.min(K,size);
    for(int i=0;i<K;i++){
        stack.push(q.dequeue());
    }
    int[]remaining=new int[size-K];
    for(int i=0;i<size-K;i++){
        remaining[i]=q.dequeue();
    }
    while(!stack.isEmpty()){
        q.enqueue(stack.pop());
    }
    for(int i=0;i<size-K;i++){
        q.enqueue(remaining[i]);
    }
}
public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    int t, n, q1, q2, k;
    t = Integer.parseInt(s.nextLine());
    while(t>0)
    {
      QueueArray ob1=new QueueArray();
      n = Integer.parseInt(s.nextLine());
      k = Integer.parseInt(s.nextLine());
      q2=n;
      while(n>0)
      {
        q1 = Integer.parseInt(s.nextLine());
        ob1.enqueue(q1);
        n--;
      }
      reverseKelementsQueue(ob1, k);
      while(q2>0)
      {
        System.out.print(ob1.dequeue() + " ");
        q2--;
      }
    System.out.println();
    t--;
    }
  }
}
