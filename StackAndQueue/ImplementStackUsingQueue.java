import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.offer(x);

        for (int i = q.size() - 1; i > 0; i--) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {

    }
}
    


/*Similarly:

Queue<Integer> q = new LinkedList<>();

Queue says:

I need queue operations like offer(), poll(), peek().

LinkedList provides those operations.
*/
