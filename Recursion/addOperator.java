import java.util.ArrayList;

public class AddOperator {
    public static void main(String[] args) {
          String num = "123";  
        int target = 6;      
        System.out.println(addOperator( num,target));
    }
    static ArrayList<String> addOperator(String num , int target){
         ArrayList<String>result = new ArrayList<>();
         solve(num,target,0,"",0,0,result);
         return result;
    }
    static void solve(String num,int target,int index,String expression,long value,long previousNumber,ArrayList<String> result){
           if(index == num.length()){
                if(value == target){
                     result.add(expression);
                }
                return;
           }
            for (int i = index; i < num.length(); i++) {

            // Don't allow leading zeros
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            // Make current number
            long currentNumber = Long.parseLong(
                    num.substring(index, i + 1)
            );

            // First number: don't put an operator
            if (index == 0) {

                solve(
                    num,
                    target,
                    i + 1,
                    expression + currentNumber,
                    currentNumber,
                    currentNumber,
                    result
                );

            } else {

                // +
                solve(
                    num,
                    target,
                    i + 1,
                    expression + "+" + currentNumber,
                    value + currentNumber,
                    currentNumber,
                    result
                );

                // -
                solve(
                    num,
                    target,
                    i + 1,
                    expression + "-" + currentNumber,
                    value - currentNumber,
                    -currentNumber,
                    result
                );

                // *
                long newValue =
                        value - previousNumber
                        + previousNumber * currentNumber;

                solve(
                    num,
                    target,
                    i + 1,
                    expression + "*" + currentNumber,
                    newValue,
                    previousNumber * currentNumber,
                    result
                );
            }
        }
    }
}


/*🔑 Recursion pattern
At every recursive call:

Choose a number
       ↓
Is it first number?
   ↙       ↘
 yes       no
           ↓
      try +, -, *
           ↓
       recursive call
           ↓
       backtrack 
       
  🧠 One-line memory trick
"Choose number → check zero → first number directly → + - * → recurse → check target." */

/*⏱️ Time Complexity
Let n = num.length().

At each position, we can choose different lengths of numbers and put operators between them.

There are roughly 3 choices at each position:

+
-
*

So the recursion is exponential.

Time:
O(3^n × n)

Let's break it down.

First: where does 3^n come from?

At each operator position, you have 3 choices:

       number
      /   |   \
     +    -    *

So approximately:

1 position → 3 choices
2 positions → 3 × 3 = 9
3 positions → 3 × 3 × 3 = 27

Therefore:

3^n
Then why × n?

Look at this:

expression + "+" + currentNumber

We are creating/copying an expression.

For example, near the end:

1+2*3+4*5+6

This expression has length proportional to n. 
So one recursive path may require O(n) work for constructing/manipulating the expression
*/

/*💾 Space Complexity
Recursion depth can go up to n.

The expression can also contain O(n) characters.

So auxiliary recursion space:

O(n)

But the result list itself can contain exponentially many expressions.

Therefore:

Auxiliary Space = O(n)
Output Space = O(3^n × n)

In your recursion problem

You have:

solve(num, target, index, expression, value, previousNumber, result)

Every recursive call goes onto the recursion call stack.

For example:

solve(...)
   ↓
solve(...)
   ↓
solve(...)
   ↓
solve(...)

The maximum depth can be n (where n = num.length()).

So the recursion stack uses:

O(n)

Therefore:

Auxiliary Space = O(n)

What about result?

Your:

ArrayList<String> result

stores all the answers.

That is output space, not auxiliary space.

So:

Auxiliary Space → O(n)
Output Space     → O(3^n × n)
*/

   