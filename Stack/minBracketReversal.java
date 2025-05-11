/* Ques: Given an expression having only square brackets ‘[‘ and ‘]’. Find the minimum number of brackets reversals required to make the
  expression balanced.
   The core idea is: Remove all balanced pairs of brackets first, then count how many unmatched opening ([) and closing (]) brackets remain.
                     These unmatched brackets require reversals to balance the expression.
   Step1: If the string length is odd, return -1 because you can’t possibly form balanced pairs.
   Step2: Initialize a stack to process each character:
          If current character is ] and top of stack is [, they form a valid pair → pop.
          Otherwise, push the character onto the stack.
   Step3: Count: openBrackets: number of '[' in the stack, closeBrackets: number of ']' in the stack.
   Step4: Every 2 unmatched brackets of the same type → need 1 reversal. */
import java.util.*;
class Result
{
  static int minReversal(String expr){
    // Write your code here
      if(expr.length()%2!=0){
          return -1;
      }
      Stack<Character>stack=new Stack<>();
      for(char c:expr.toCharArray()){
          if(c==']' && !stack.isEmpty() && stack.peek()=='['){
              stack.pop();
          }
          else{
              stack.push(c);
          }
      }
      int openBrackets=0,closeBrackets=0;
      while(!stack.isEmpty()){
          if(stack.pop()=='['){
              openBrackets++;
          }
          else{
              closeBrackets++;
          }
      }
      return (int)(Math.ceil(openBrackets/2.0)+Math.ceil(closeBrackets/2.0));
     }
}
class Main
{
  public static void main(String[] args)
  {
    int t, ans;
    Scanner s=new Scanner(System.in);
    t = Integer.parseInt(s.nextLine().trim());
    while(t!=0)
    {
      String expr;
      expr = s.nextLine().trim();
      ans = Result.minReversal(expr);
      System.out.println(ans);
      t--;
    }
  }
}
