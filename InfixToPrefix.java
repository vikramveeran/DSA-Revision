import java.util.*;

public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "x+y*z/w+u"; 
        System.out.println(infixToPrefix(exp)); // Output: ++x/*yzwu
    }

    static int priority(char operator) {
        if (operator == '^') {
            return 3;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    // Helper postfix function modified for infix-to-prefix conversion logic
    static String infixToPostfixForPrefix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                st.push('(');
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // For prefix conversion on reversed strings, use priority(c) < priority(st.peek())
                // for equal precedence (e.g., ^ vs +, *, /) to maintain correct operator associativity
                while (!st.isEmpty() && (
                        (c == '^' && priority(c) <= priority(st.peek())) ||
                        (c != '^' && priority(c) < priority(st.peek()))
                )) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.toString();
    }

    static String infixToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        String postfix = infixToPostfixForPrefix(sb.toString());

        return new StringBuilder(postfix).reverse().toString();
    }
}

/*steps:-
reverse the infix
infToPos
reveseTheresult
*/

