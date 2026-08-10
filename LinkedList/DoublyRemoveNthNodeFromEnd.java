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
public class DoublyRemoveNthNodeFromEnd {
    static Node RemoveNthNodeFromEnd(Node head,int n){
             Node slow = head;
             Node fast = head;
             for(int i=0; i<n; i++){
                   fast = fast.next;
             }
             while(fast.next != null){
                 slow = slow.next;
                 fast = fast.next;
             }
             slow.next = slow.next.next;
             return head;
    }
    static void printLL(Node head){
         while(head != null){
             System.out.println(head.data);
             head= head.next;
         }
    }
    public static void main(String[] args) {
           Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);
        head = RemoveNthNodeFromEnd(head,3);
        printLL(head);
    }
}
