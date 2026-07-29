package LinkedList;
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
public class DeletionRemoveKElement {
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
static Node removeKElement(Node head,int el){
      if(head == null){
         return head;
      }
      if(el == head.data){
        Node temp = head;
         head = head.next;
         return head;
      }

      Node temp = head;
      Node prev = null;
      while(temp != null){
         if(el == temp.data){
            prev.next = prev.next.next;
            break;
         }
           prev = temp;
         temp = temp.next;
        
      }
      return head;
}

static void print(Node head){
     while(head != null){
         System.out.println(head.data);
         head = head.next;
     }
}


     public static void main(String[] args) {
         int[] arr = {1,2,3,4};                      
        Node head  = convertArrToLL(arr);
        head = removeKElement(head,3);
        print(head);
     }
}
