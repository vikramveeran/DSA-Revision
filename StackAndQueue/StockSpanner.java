import java.util.*;

public class StockSpanner {

    Stack<Pair> stack = new Stack<>();

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));

        return span;
    }

    public static void main(String[] args) {

        StockSpanner s = new StockSpanner();

        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }
}

class Pair {
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

/*Time & Space Complexity
Time complexity: 
O(n)
Space complexity: 
O(n) */