/* Ques: Given a postfix expression, evaluate it using stack and print the final output.
   Sample Input:
   1(testcase) 
   8425+-* 
   Sample Output:
   -24 (8 * (4 - (2 + 5)) = -24)

   Step1: Loop through each character in the expression:
   Step2: If it's a digit, convert it to integer and push onto the stack:
   Step3: If it's an operator, pop two elements , Apply the operation and push the result back. */
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

class Main
{
/* isEmpty(), isFull(), push(int) and int pop() functions available on Stack. */

static int evalPostfix(CQStack s, String exp) {
  // Write your code here
    for(char ch:exp.toCharArray()){
        if(Character.isDigit(ch)){
            s.push(ch-'0');
        }
        else{
            int b=s.pop();
            int a=s.pop();
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
public static void main(String[] args)
  {
    CQStack theStack = new CQStack(100); // make new stack
    Scanner s=new Scanner(System.in);
    int t, n, q1, q2;
    String st;
    t = Integer.parseInt(s.nextLine().trim());
    while(t>0)
    {
      st = s.nextLine().trim();
      System.out.println(evalPostfix(theStack, st));
      t--;
    }
  }
}
