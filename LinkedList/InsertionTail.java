package LinkedList;
class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        this.data= data1;
        this.next = next1;
    }
    Node(int data1){
        this.data= data1;
        this.next = null;
    }
}
public class InsertionTail {
    static Node  convertArrToLL(int arr[]){
     Node head = new Node(arr[0]);
     Node mover  = head;
      for(int i=1; i<arr.length; i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
          mover = temp;
      }
      return head;
}
static insertionTail(Node head,int val){
     if(head == null){
        Node temp = new Node(val);
         return temp;
     }
     Node temp = head;
     while(temp.next != null){
         temp = temp.next;
     }
     Node newNode = new Node(val);
     return head;          
}
    public static void main(String[] args) {
          
    }
}
