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
public class Searchelement {
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

static int searchElement(Node head,int target){
       Node temp = head;
       while(temp != null){
           if(temp.data == target){
             return 1;
           }
           temp = temp.next;
       }
       return 0;
}
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Node head  = convertArrToLL(arr);
        int temp = searchElement(head,4);
        System.out.println(temp);
    }
}
