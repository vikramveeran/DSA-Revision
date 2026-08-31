package BitManupulation;

public class ClearIthBit {
    public static void main(String[] args) {
        int n = 9;
        int i =2;
        System.out.println(clearIthBit(n,i));
    }
    static int clearIthBit(int n,int i){
         int result = (n&(~(1<<i)));
         return result;
    }
}
    

/*Time: O(1)
Auxiliary Space: O(1) */