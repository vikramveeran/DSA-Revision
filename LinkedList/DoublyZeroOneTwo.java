class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
         this.data = data1;
         this.next = next1;
    }
     Node(int data1){
         this.data = data1;
         this.next = null;
    }
}
public class DoublyZeroOneTwo{
static Node sortZeroOneTwo(Node head) {
        // Create dummy nodes for 0s, 1s, and 2s
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Create tail pointers to add new nodes in respective lists
        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;

        Node curr = head;

        // Traverse the original list
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Connect 0s list to 1s, and 1s to 2s
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Update original list head
        return zeroDummy.next;
    }

    public static void main(String[] args) {
         Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
       head = sortZeroOneTwo(head);
       while(head != null){
        System.out.println(head.data);
        head = head.next;
       }
    }
}