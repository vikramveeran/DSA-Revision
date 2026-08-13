package Recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
         Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
          sortStack(stack);
          while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    static void insert(Stack<Integer>stack,int temp){
         if(stack.isEmpty() || stack.peek() <= temp){
              stack.push(temp);
              return;
         }
         int val = stack.pop();;
         insert(stack,temp);

        stack.push(val);

    }
    static void sortStack(Stack<Integer>stack){
          if(!stack.isEmpty()){
             int temp = stack.pop();
             sortStack(stack);
             insert(stack,temp);
          }
    }
}
