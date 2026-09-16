import java.util.*;

public class PrefixToInfix {
    public static void main(String[] args) {
        String exp = "*+ab-cd";
        System.out.println(prefixToInfix(exp));
    }
    static String prefixToInfix(String postfix) {
        Stack<String> s = new Stack<>();
        int n = postfix.length();

        for (int i = n-1; i >=0; i--) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                s.push(String.valueOf(c));
            } else {
                
                String op1 = s.pop();
                String op2 = s.pop();

                
                s.push("(" + op1 + c + op2 + ")");
            }
        }
        return s.peek();
    }
}
// same like PostfixToInfix just you have iterrate from last 