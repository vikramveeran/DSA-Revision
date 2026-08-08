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
                                                                        
public class FindMiddleElement {
    static Node MiddleElement(Node head){
       Node slow = head;
       Node fast = head;
       while(fast != null && fast.next != null){
                  slow = slow.next;
                  fast  = fast.next.next;
       }
       return slow;
}
    public static void main(String[] args) {                                 
        Node head = new Node(10);
        head.next = new Node(20);                            
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);                          

        Node result = MiddleElement(head);                       
        System.out.println(result.data);
    }
}