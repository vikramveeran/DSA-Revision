import java.util.Stack;

public class LRA {
    public static void main(String[] args) {
        
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                 (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

/*🧠 Pattern to Remember
"Smaller comes → Pop → Calculate"
For every index i:

1. If current height >= stack top
       → PUSH index

2. If current height < stack top
       → POP
       → popped height = rectangle height
       → calculate width
       → calculate area

3. At the end (i == n)
       → Pop all remaining elements */



       /*⏱️ Time Complexity
O(N)

Even though there is a while loop inside the for loop, it's not O(N²).

Why?

Every index is:

pushed into stack once
popped from stack once

So maximum operations are roughly:

N pushes + N pops
= 2N
= O(N)

Therefore:

TC = O(N)
💾 Space Complexity

The stack can contain up to N indices.

SC = O(N) */