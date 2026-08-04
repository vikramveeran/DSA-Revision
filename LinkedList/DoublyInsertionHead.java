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

public class DoublyInsertionHead {
     static Node convertArrToDLL(int arr[]){
         Node head = new Node(arr[0]);
         Node prev = head;
         for(int i=1; i<arr.length; i++){
             Node temp  = new Node(arr[i],null,prev);
             prev.next = temp;
             prev = temp;
         }
         return head;
   }
   static Node insertionHead(Node head,int val){
      Node newNode = new Node(val,head,null);
      head.back = newNode;
      return head;
   }
    static void print(Node head){
      while(head != null){
         System.out.println(head.data);
         head = head.next;
      }
    }
    public static void main(String[] args) {
          int[] arr = {10,30,50,70};
         Node head = convertArrToDLL(arr);
           insertionHead(head,5);
         print(head);
    }
}
