package BitManupulation;

public class EvenOrOdd {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(evenOrOdd(num));
    }
   static String evenOrOdd(int num){
     int result =( num & 1);
     if(result == 0){
         return "Even";
     }
     return "odd";
   }
}
