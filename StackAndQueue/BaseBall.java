import java.util.*;

public class BaseBall {
    public static void main(String[] args) {
        String[] st = {"5","D","+","C"};
        System.out.println(baseBall(st));
    }
    static int baseBall(String[] ops){
         Stack<Integer>st = new Stack<>();
         int result = 0;
         for(String c : ops){
             if(c.equals("+")){
                 int top = st.pop();
                 int newTop = top + st.peek();
                 st.push(top);
                 st.push(newTop);
             }
             else if (c.equals("D")) {
                st.push(2 * st.peek());
            }
             else if(c.equals("C")){
                 st.pop();
             }
             
             else{
                 st.push(Integer.parseInt(c));
             }
         }
         for(Integer val : st){
             result += val;
         }
         return result;
    }
}


/*Time & Space Complexity
Time complexity: 
O(n)

Space complexity: 
O(n) */