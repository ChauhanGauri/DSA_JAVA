/* Ques: Given a prefix expression, evaluate it using stack and print the final output.
   Sample Input:
   1 (testcase)
   +-*235/^234
   Sample Output: 3 
   Same as PostFix , just start looping from right to left of expression */
import java.util.*;

class CQStack
{
  public int maxSize; // size of stack array
  public int[] stackArray;
  public int top; // top of stack

  public CQStack(int s) // constructor
  {
    maxSize = s; // set array size
    stackArray = new int[maxSize]; // create array
    top = -1; // no items yet
  }
  public boolean isEmpty() // true if stack is empty
  {
    return (top == -1);
  }
  public boolean isFull() // true if stack is full
  {
    return (top == maxSize-1);
  }

  public void push(int j) // put item on top of stack
  {
    if(isFull())
    {
    }
    else
    {
      stackArray[++top] = j; // increment top, insert item
    }
  }
  public int pop() // take item from top of stack
  {
    if (isEmpty())
    {
      return -1;
    }
    else
    {
      int temp=stackArray[top--];
      return temp; // access item, decrement top
    }
  }
}

class Result {
  static int evalPrefix(CQStack s, String exp) {
      for(int i=exp.length()-1;i>=0;i--){
          char ch=exp.charAt(i);
          if(Character.isDigit(ch)){
              s.push(ch-'0');
          }
          else{
              int a=s.pop();
              int b=s.pop();
              switch(ch){
                  case '+':s.push(a+b);break;
                  case '-':s.push(a-b);break;
                  case '*':s.push(a*b);break;
                  case '/':s.push(a/b);break;
                  case '^':s.push((int)Math.pow(a,b));break;
              }
          }
      }
      return s.pop();
      
  }
}
class Main
{
  public static void main(String[] args)
  {
    CQStack theStack = new CQStack(100); // make new stack
    Scanner s=new Scanner(System.in);
    int t, n, q1, q2;
    String st;
    t = Integer.parseInt(s.nextLine());
    while(t>0)
    {
      st = s.nextLine();
      System.out.println(Result.evalPrefix(theStack, st));
      t--;
    }
  }
}
