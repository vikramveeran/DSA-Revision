
class Node{
    int data;
    Node next;
    Node back;

    Node(int data1,Node next1,Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class DoublyRemoveDuplicates {
    static Node removeDuplicates(Node head){
         Node current = head;
         while(current != null && current.next != null){
            Node nextdistinctNode = current.next;
            while(nextdistinctNode != null && nextdistinctNode.data == current.data){
                nextdistinctNode = nextdistinctNode.next;
            }
            current.next = nextdistinctNode;
            if(nextdistinctNode != null){
                nextdistinctNode.back = current;
            }
            current = current.next;
         }
         return head;
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next  = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node result = removeDuplicates(head);
        while(result != null){
            System.out.println(result.data);
            result = result.next;
        }
    }
}
