
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

public class DoublyDeleteKthValue {
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
    static Node deletionHead(Node head){
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
   }
   static Node deleteTail(Node head){
      Node tail = head;
      while(tail.next != null){
         tail = tail.next;
      }
      Node prev = tail.back;
      prev.next = null;
      tail.back = null;
      return head;
   }

   static Node deleteKthValue(Node head,int k){
       if(head == null){
         return null;
       }
      Node KNode = head;
      int count = 0;
      while(KNode != null){
        count++;
        if(count == k){
            break;
        }
         KNode = KNode.next;
      }
      Node prev = KNode.back;
      Node front = KNode.next;
      if(prev == null && front == null){
         return null;
      }
      if(prev == null){
         return deletionHead(head);
      }
      if(front  == null){
         return deleteTail(head);
      }
      
      prev.next = front;
      front.back = prev;

      KNode.next = null;
      KNode.back = null;

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
         head =  deleteKthValue(head,4);
         print(head);
    }
    
}
