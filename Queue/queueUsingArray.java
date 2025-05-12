/*Sample Input:               Sample Output:                  Explanation:First query is insert 3,
  1                           3 4 2 6                                     then delete will print 3, 
  8                                                                       3rd query is insert 4,
  1                                                                       then insert 2,
  3                                                                       5th query is delete which prints 4, 
  2                                                                       6th query is insert 6, 
  1                                                                       then delete will print 2 and                                                                         
  4                                                                       last query of delete will print 6.
  1
  2
  2
  1
  6
  2
  2
  Input Format
  First line of input contains an integer T denoting number of test cases. Each test case contains an integer Q denoting the number of queries.
  A Query is of 2 Types
  (a) 1 <item>  (a query of this type means insert 'item' into the queue)
  (b) 2   (a query of this type means to delete element from queue and print the deleted element)
  The next lines of each test case contains Q queries.
*/      
 
import java.util.*;
class QueueArray
{
  static int SIZE=100;
  static int front=-1;
  static int rear=-1;
  static int array[]=new int[SIZE];
  QueueArray()
  {
    front=rear=-1;
  }
  // Method to add an item to the queue.
  void enqueue(int item)
  {
      if(rear==SIZE-1){
          return;
      }
      if(front==-1){
          front++;
      }
      array[++rear]=item;
  }
  // Method to remove an item from queue.
  int dequeue()
  {
      if(front==-1 || front>rear){
          return -1;
      }
      return array[front++];
  }
}
class Main
{
  public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    int t, n, q1, q2;
    t = s.nextInt();
    while(t>0)
    {
      QueueArray ob1=new QueueArray();
      n = s.nextInt();
      while(n>0)
      {
        q1 = s.nextInt();
        if(q1 == 1)
        {
          q2 = s.nextInt();
          ob1.enqueue(q2);
        }
        else
          System.out.print(ob1.dequeue() + " ");
        n--;
      }
      System.out.println();
      t--;
    }
  }
}
