import java.util.*;

public class PostfixToPrefix {
    public static void main(String[] args) {
      System.out.println(postfixToPrefix("ab+"));
    }
    static String postfixToPrefix(String postfix){
         Stack<String>st = new Stack<>();
         for(int i=0; i<postfix.length(); i++){
            char c = postfix.charAt(i);
             if(Character.isLetterOrDigit(c)){
                 st.push(String.valueOf(c));
             }
             else{
                 String op2 = st.pop();
                 String op1 = st.pop();

                 st.push(c+op1+op2);
             }
         }
         return st.peek();
    }
}
