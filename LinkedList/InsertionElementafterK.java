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
public class InsertionElementafterK {
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
static Node InsertionElementAfterK(int val,int k,Node head){
       if(head == null){
          if(k == 1){
            return new Node(val);
          }
          else{
             return null;
          }
       }
       int count =0;
       Node temp = head;
       while(temp != null){
         count++;
         if(count == k-1){
             Node x = new Node(val);
            x.next = temp.next;
            temp.next = x;
            break;
         }
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
        int[] arr = {10,20,30,40,50,60};      
        int val = 6;                
        Node head  = convertArrToLL(arr);
        head = InsertionElementAfterK(100,4,head);
        print(head);
    }
}