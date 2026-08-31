package BitManupulation;

public class SetOrNot {
    public static void main(String[] args) {
        int n = 13;
        int i  = 2;
        System.out.println(setOrNot(n,i));
    }
    static boolean setOrNot(int n,int i){
         if((n &(1<<i)) != 0){
             return true;

         }
         return false;
    }

}

/*for right shift
(n>>i)&1 == 0
*/

/*Time Complexity: O(1)
Auxiliary Space: O(1) */

