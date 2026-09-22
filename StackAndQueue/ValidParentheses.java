import java.util.*;



public class ValidParentheses {
    public static void main(String[] args) {
        String parentheses = "([{}])";
        System.out.println(validParenthese(parentheses));
        
    }
    static Boolean validParenthese(String parentheses){
         Stack<Character>st = new Stack<>();
         HashMap<Character,Character>closeToOpen = new HashMap<>();
         closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
         for(Character c : parentheses.toCharArray()){
             if(closeToOpen.containsKey(c)){
                  if(!st.isEmpty() && st.peek() == closeToOpen.get(c)){
                        st.pop();
                  }
                  else{
                    return false;
                  }
             }
             else{
                st.push(c);
             }
         }
         return st.isEmpty();
    }
}

/*We can use a stack to store characters. Iterate through the string by index. 
For an opening bracket, push it onto the stack. If the bracket is a closing type,
 check for the corresponding opening bracket at the top of the stack. If we don't find the corresponding opening bracket,
  immediately return false. Why does this work? */
