/* Step1: Create a new array of the same size as queue
   Step2: Dequeue elements from queue and copy to array
   Step3: Loop from end of array and enqueue elements*/
import java.util.*;
class QueueArray
{
  static int SIZE=100;
  static int front=-1;
  static int rear=-1;
  static int array[]=new int[SIZE];

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
    if (front > rear)
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
static void reverseQueue(QueueArray q){
  // Write your code here
    if(q.front==-1 || q.front>q.rear)
        return ;
    int size=q.rear-q.front+1;
    int[]temp=new int[size];
    int index=0;
    while(q.front<=q.rear){
        temp[index++]=q.dequeue();
    }
    q.front=-1;
    q.rear=-1;
    for(int i=size-1;i>=0;i--){
        q.enqueue(temp[i]);
    }
}
public static void main(String[] args)
{
  Scanner s=new Scanner(System.in);
  int t, n, q1, q2;
  t = s.nextInt();
  while(t>0)
  {
    QueueArray ob1=new QueueArray();
    n = s.nextInt();
    q2=n;
    while(n>0)
    {
      q1 = s.nextInt();
      ob1.enqueue(q1);
      n--;
    }
    reverseQueue(ob1);
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
