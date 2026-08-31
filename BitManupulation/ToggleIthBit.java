package BitManupulation;

public class ToggleIthBit {

    public static void main(String[] args) {
     int n = 13;
     int i = 1;
     System.out.println(toggleIthBit(n,i));
    }
    static int toggleIthBit(int n,int i){
          int result = (n^(1<<i));
          return result;
    }

}

/*Time: O(1)
Auxiliary Space: O(1) */
