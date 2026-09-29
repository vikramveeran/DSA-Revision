import java.util.*;

public class Asteroid {
    public static void main(String[] args) {
        int[] ast  ={2,4,-4,-1};
        System.out.println(asteroidCollision(ast));
    }
     static public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    a = 0;
                } else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.add(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    
    }
}
