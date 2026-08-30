package BitManupulation;
import java.util.*;
public class Convert2Binary {
    public static void main(String[] args) {
        System.out.println(convertToBinary(13));
    }
    static String convertToBinary(int num){
        
        String result = "";
         while(num != 0){
            
             if(num%2 == 1){
                 result += "1";
             }
             else{ 
                result += "0";
             }
             num = num/2;
        
         }
           StringBuilder st = new StringBuilder(result);
           st.reverse();
        
         return st.toString();
    }
}
/*TC :- O(logn)  because everytime it divided by 2 
SC   :- O(logn)
*/

