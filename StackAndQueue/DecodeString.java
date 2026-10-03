import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[a3[b]]c";
        System.out.println(decodeString(s));
    }
    
    static public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(cur.toString());
                countStack.push(k);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                String temp = cur.toString();
                cur = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    cur.append(temp);
                }
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}

/*
⏱️ Time Complexity: O(n × k)
Where:

n = length of the input string
k = repetition factor

Why? Because when we see something like:

100[a]

we append "a" 100 times.

So the output itself can become much larger than the input.

A more precise way to say it in an interview:

Time Complexity: O(L), where L is the length of the decoded output string.

💾 Space Complexity: O(n)
We use:

Stack<String> stringStack
Stack<Integer> countStack
StringBuilder cur

The stacks store nested strings/counts, so the extra space is O(n) in terms of input/nesting depth, while the decoded result itself also requires space.

🧠 Interview answer
TC → O(L), L = length of decoded string
SC → O(n) auxiliary space 

🔴 Main TC part

This is the important part:

for (int i = 0; i < count; i++) {
    cur.append(temp);
}

Suppose:

3[a]

The loop runs:

i = 0 → "a"
i = 1 → "aa"
i = 2 → "aaa"

Now:

100[a]

The loop runs 100 times.

For nested input:

3[a2[c]]

we first create:

2[c] → "cc"

then:

3[acc] → "accaccacc"

So the algorithm's work depends on the size of the decoded output, not just the original
*/


/*🧠 Pattern: SAVE → RESET → BUILD → RESTORE → REPEAT
Number → [
      ↓
SAVE old string + number
      ↓
RESET current string
      ↓
BUILD inside []
      ↓
] → RESTORE old string + repeat current string
 
Just remember:

[  → Push + Reset
]  → Pop + Repeat

And the complete mental pattern:

3[a2[c]]

3 → count
[ → save 3, reset
a → build
2 → count
[ → save 2, reset
c → build
] → pop 2, repeat c → cc
] → pop 3, repeat acc → accaccacc


*/