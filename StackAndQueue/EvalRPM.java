import java.util.Stack;

public class EvalRPM {
     public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPM(tokens));
     }
     static int evalRPM(String[] tokens){
         Stack<Integer>stack = new Stack<>();
         for(String c  : tokens){
             if(c == "+"){
                 stack.push(stack.pop() + stack.pop());
             }
             else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }

         }
         return stack.pop();
     }
}
