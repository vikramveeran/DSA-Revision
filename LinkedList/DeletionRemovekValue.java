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
public class DeletionRemovekValue {
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

static Node RemoveKValue(Node head,int k){
      if(head == null){
         return head;
      }
      if(k == 1){
         head = head.next;
         return head;
      }

      Node temp = head;
      Node prev = null;
      int count  = 0;
      while(temp != null){
                count++;

         if(count == k){
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
        head = RemoveKValue(head,3);
        print(head);
    }
}
