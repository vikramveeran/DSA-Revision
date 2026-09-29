import java.util.*;
public class DailyTemp {
    public static void main(String[] args) {
        
        int[] temperature = {30,38,30,36,35,40,28};
        System.out.println(Arrays.toString(dailytemp(temperature)));
    }
    static int[] dailytemp(int[] temperature){
          Stack<Integer>stack = new Stack<>();
          int[] result = new int[temperature.length];
          for(int i=0; i<temperature.length; i++){
           
                 while(!stack.isEmpty() && temperature[i] > temperature[stack.peek()]){
                    int index = stack.pop();
                     result[index] = i - index;
                     
                 }
                stack.push(i);
             
             
          }
          return result;   
    }
   
}

/*Time Complexity: O(n)

Even though there is a while loop inside the for loop, it's still O(n).

Why?

Every index is pushed into the stack once → O(n)
Every index is popped from the stack at most once → O(n)

So:

O(n) + O(n) = O(n)
Space Complexity: O(n)

Because the stack can contain up to n indices in the worst case.

The result array also takes O(n) space.

So strictly including the output:

Space = O(n)

If discussing auxiliary space excluding the result array:

Auxiliary Space = O(n) */
