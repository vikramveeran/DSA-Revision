import java.util.Stack;

public class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    
     public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    public static void main(String[] args) {
        

      MinStack ms = new MinStack();

    ms.push(5);
    ms.push(3);
    ms.push(7);
    ms.push(2);

    System.out.println("Top: " + ms.top());
    System.out.println("Min: " + ms.getMin());

    ms.pop();

    System.out.println("Top after pop: " + ms.top());
    System.out.println("Min after pop: " + ms.getMin());
    }
    void  push(int x){
         
        st.push(x);

        if(minStack.isEmpty() || x<= minStack.peek()){   
             minStack.push(x);
        }

    } 
    void pop(){
         if (st.isEmpty()) return;
        int top = st.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
     int top() {
        return st.peek();
    }

     int getMin() {
        return minStack.peek();
     }
}


/*  */