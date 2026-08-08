
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
public class DoublyStartingPointOfLoop {
    static Node StartingPointOfLoop(Node head){
          Node slow = head;
       Node fast = head;
       while(fast != null && fast.next != null){
                  slow = slow.next;
                  fast  = fast.next.next;
                  if(slow == fast){
                      while( slow != fast){
                         slow = slow.next;
                         fast = fast.next;
                      }
                      return slow;
                  }
       }
       return null;
    }
    public static void main(String[] args) {
          Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4); 

        // Create cycle: last node connects to node with value 2
        head.next.next.next.next = head.next;
        Node result= StartingPointOfLoop( head);
        System.out.println(result.data);
    }
}
