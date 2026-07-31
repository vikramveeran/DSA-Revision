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
public class InsertionElementBeforeVal {
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
static Node InsertionElementBeforeVal(int val,int el,Node head){
       if(head == null){
        return null;
       }
          if(head.data == val){
            return new Node(el,head);
          }
       
       Node temp = head;
       while(temp.next != null){
       
         if(temp.next.data == val){
             Node x = new Node(el,temp.next);
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
        Node head  = convertArrToLL(arr);
        head = InsertionElementBeforeVal(30,100,head);
        print(head);
    }

}
