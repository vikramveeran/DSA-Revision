import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        infixToPos(exp);
    }

    static int priority(char operator) {
        if (operator == '^') {
            return 3;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-')
            return 1;
        else
            return -1;
    }

    static void infixToPos(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int Char = 0; Char < exp.length(); Char++) {
            char c = exp.charAt(Char);

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
                // 2. Handle operator precedence & associativity correctly
                while (!st.isEmpty() && ((c != '^' && priority(c) <= priority(st.peek())) ||
                        (c == '^' && priority(c) < priority(st.peek())))) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        System.out.println("Postfix expression: " + result.toString());

    }
}

/*⏱️ Time Complexity
Let n = exp.length().

1. Main for loop
for (int Char = 0; Char < exp.length(); Char++)

We visit every character once:

O(n)
2. But what about the while loops?

You might think:

while (!st.isEmpty() ...)

makes it O(n²) because it is inside the for loop.

It is NOT O(n²).

Every operator that gets pushed into the stack can be popped only once.

Example:

Push → Push → Push → Pop → Pop → Pop

So across the entire algorithm, there are at most n pushes and n pops.

Therefore:
✅ Time Complexity = O(n) */

/* 💾 Space Complexity
You use:

Stack<Character> st

The stack can contain up to n operators.

And:

StringBuilder result

can contain up to n characters.

Therefore:

Auxiliary space
O(n)
Output/result space
O(n)

So overall:

✅ Space Complexity = O(n)*/


/*            
                  ┌──────────────────────┐
                  │    Scan Character    │
                  └──────────┬───────────┘
                             │
     ┌───────────────────────┼───────────────────────┬──────────────────────┐
     ▼                       ▼                       ▼                      ▼
[ Operand ]             [ Open '(' ]             [ Close ')' ]         [ Operator ]
 Direct Pass             High Priority             Unwind Stack          Precedence Loop
  ➔ Append               ➔ Push to                 ➔ Pop to result       ➔ Pop higher/equal
    to result               stack                    until '('             ➔ Push current 
    
*/


