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
public class InsertionHead {
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
static Node insertHead(Node head,int val){
   Node temp = new Node(val,head);
   return temp;
}
static void print(Node head){
     while(head != null){
         System.out.println(head.data);
         head = head.next;
     }
}
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};      
        int val = 6;                
        Node head  = convertArrToLL(arr);
        head = insertHead(head,val);
        print(head);
       
    }
}
