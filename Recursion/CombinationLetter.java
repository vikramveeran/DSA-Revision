import java.util.*;

public class CombinationLetter {
    public static void main(String[] args) {
        String  digits = "23";
        List<String>Answer  = combination(digits);
        for(String An : Answer){
             System.out.println(An);
        }
    }
    static void helper(String digits,int index,String current,List<String>result,String[] map){
         if (index == digits.length()) {
            result.add(current);
            return;
        }
             int digit = digits.charAt(0)-'0';
             String letters = map[digit];

             for(Character ch : letters.toCharArray()){
                helper( digits,index+1, current+ch,result,map);
             }
    }
    static List<String> combination(String digits){
        List<String>result = new ArrayList<>();
         String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        if(digits.length() == 0){
             return result;
        }

         helper(digits,0,"",result,map);
         return result;
    }
}
/*🧠 Pattern to Remember
"One digit → One level → Try every letter"

For every digit:

get letters
    ↓
try each letter
    ↓
add letter to current
    ↓
go to next digit
    ↓
when all digits are used → store answer
 */

/*⏱️ Time Complexity
Let:

n = number of digits
Each digit has at most 4 letters (7 and 9 have 4)

Therefore, maximum combinations:

4 × 4 × 4 × ... × 4
        n times

= 4ⁿ

But we also construct/copy a string of length n for every answer.

So the overall complexity is:

O(4ⁿ × n)

Why × n?

Because there can be 4ⁿ answers, and each answer has length n. */

/* 💾 Space Complexity
There are two things:

Recursion stack

Depth = number of digits:

O(n)
Result

We store 4ⁿ strings, each of length n:

O(4ⁿ × n)

So if we include the output:

Space = O(4ⁿ × n)

If an interviewer asks for auxiliary space excluding the output, it's:

O(n)*/