
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

public class DoublyDeleteAllOccurenceKey {
    static Node deleteAllOccurence(Node head,int key){
        Node temp = head;
         while(temp != null){
          Node nextNode = temp.next;

if (temp.data == key) {

    if (temp.back != null)
        temp.back.next = temp.next;
    else
        head = temp.next;

    if (temp.next != null)
        temp.next.back = temp.back;
}

temp = nextNode;
         }
         return head;
    }
    public static void main(String[] args) {
     Node head = new Node(2);
    head.next = new Node(3);
    head.next.next = new Node(4);
    head.next.next.next = new Node(3);
    Node result = deleteAllOccurence(head,2);
    while(result != null){
         System.out.println(result.data);
         result = result.next;
    }
    }

}
