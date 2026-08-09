 class Node{
    int data;
    Node next;
    Node back;
    Node(int data1){
         this.data = data1;
         this.next = null;
         this.back = null;
    }
    Node(int data1,Node next1,Node back1){
        this.data = data1;
         this.next = next1;
         this.back = back1;
    }
}
public class DoublyLLCheckPalindrome {
     public static Node reverseLinkedList(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the new head
        Node newHead = reverseLinkedList(head.next);

        // Store the next node in 'front' to reverse the link
        Node front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the original link
        head.next = null;

        // Return the new head obtained from the recursion
        return newHead;
    }
    public static boolean isPalindrome(Node head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return true;  // It's a palindrome by definition
        }

        // Initialize two pointers, slow and fast, to find the middle of the linked list
        Node slow = head;
        Node fast = head;

        // Traverse the linked list to find the middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // Move slow pointer one step at a time
            fast = fast.next.next;  // Move fast pointer two steps at a time
        }

        // Reverse the second half of the linked list starting from the middle
        Node newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        Node first = head;

        // Pointer to the reversed second half
        Node second = newHead;

        // Compare data values of nodes from both halves
        while (second != null) {
            if (first.data != second.data) {
               
                reverseLinkedList(newHead);  // Reverse the second half back to its original state
                return false;
            }

            first = first.next;  
            second = second.next;
        }

        // Reverse the second half back to its original state
        reverseLinkedList(newHead);

      
        return true;
    }

    public static void main(String[] args) {
         Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        Boolean result = isPalindrome(head);
        System.out.println(result);
    }
}
