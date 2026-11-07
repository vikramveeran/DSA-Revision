package LL;

public class Reverse {

    static class ListNode {
        int val;
        ListNode next;

        // ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseList(head);

        // Print reversed linked list
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }
}

/*Time and Space Complexity
Complexity	Value	Reason
Time	O(n)	We visit every node exactly once.
Space	O(1)	We use only three pointers, regardless of list size. */

/*I used an iterative approach with three pointers: previous, current, and temporary.

Initially, previous is null and current points to the head.

For every node, I first save the next node in a temporary pointer. Then I reverse the current node's link by pointing it to the previous node.

After that, I move the previous and current pointers forward.

I repeat this until current becomes null. Finally, I return previous because it points to the new head of the reversed linked list.

The time complexity is O(n), and the space complexity is O(1). */