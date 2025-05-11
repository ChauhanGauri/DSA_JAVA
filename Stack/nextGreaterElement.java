/*Given an array having distinct integer elements, the task is to find the first next greater element on right side for each element of the 
  array. If no such element exists, output -1.
  Step1: Initialize an array to store next greater element on right side of each element
  Step2: Initialize an empty stack to keep track of candidates for the Next Greater Element.
  Step3: Loop from right to left over the input array, While the stack is not empty AND the top of the stack (stack.peek()) is less than 
  or equal to arr[i],Pop the top element (because it can't be the NGE for arr[i] or any element to its left).
  Step4: If the stack is empty, then there is no greater element to the right → nge[i] = -1
         Else, the top of the stack is the Next Greater Element → nge[i] = stack.peek()
          Push arr[i] onto the stack
*/
 
import java.util.*;
class Result{
  static void printNextGreaterElement(int arr[],int n){
    // Write your code here
      int[]nge=new int[n];
      Stack<Integer> stack=new Stack<>();
      for(int i=n-1;i>=0;i--){
      while(!stack.isEmpty() && stack.peek()<=arr[i]){
          stack.pop();
      }
          nge[i]=stack.isEmpty()?-1:stack.peek();
          stack.push(arr[i]);
      }
      for(int i=0;i<n;i++){
          System.out.print(nge[i]+" ");
      }
      System.out.println();
      
  }
}
class Main
{
  public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    Result result = new Result();
    int t = s.nextInt();
    while(t-- > 0){
      int n;
      n = s.nextInt();
      int arr[] = new int[n];
      int i=0;
      for(i=0;i<n;i++)
        arr[i] = s.nextInt();
      result.printNextGreaterElement(arr,n);
      System.out.println();
    }
  }
}
