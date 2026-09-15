import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        
    }c
      public String postfixToInfix(String postfix) {
        Stack<String> s = new Stack<>();
        int n = postfix.length();

        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                s.push(String.valueOf(c));
            } else {
                
                String op2 = s.pop();
                String op1 = s.pop();

                
                s.push("(" + op1 + c + op2 + ")");
            }
        }


        return s.peek();
    }
}
/*⏱️ Time Complexity
Let n = postfix.length().

for (int i = 0; i < n; i++)

You visit every character exactly once.

Each operand → push() → O(1) approximately
Each operator → 2 pop() + 1 push() → O(1) for stack operations
But string concatenation creates a new string, so for a straightforward complexity analysis, it is usually given as O(n).

Time Complexity: O(n) */

/*💾 Space Complexity

The stack can contain up to O(n) strings in the worst case.

Space Complexity: O(n) */

/*🧠 Pattern to Remember

For Postfix → Infix, remember:

Operand → PUSH
Operator → POP 2 → COMBINE → PUSH */