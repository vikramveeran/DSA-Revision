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
public class SinglyIntersectionNode {
    static Node IntersectionLL(Node head1,Node head2){
           Node dummyNode1 = head1;
           Node dummyNode2 = head2;
           while(dummyNode1 != dummyNode2){
             dummyNode1 = dummyNode1 == null ?head2 : dummyNode1.next;
             dummyNode2 = dummyNode2 == null ?head1 : dummyNode2.next;

           }
           return dummyNode1;
    }
    public static void main(String[] args) {
         // Common part
    Node common = new Node(2);
    common.next = new Node(4);

    // First list
    Node head1 = new Node(1);
    head1.next = new Node(3);
    head1.next.next = new Node(1);
    head1.next.next.next = common;

    // Second list
    Node head2 = new Node(3);
    head2.next = common;

       Node head = IntersectionLL(head1,head2);
        System.out.println(head.data);
    }
}
