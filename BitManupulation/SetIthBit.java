package BitManupulation;

public class SetIthBit {
    public static void main(String[] args) {
        int n = 9;
        int i =2;
        System.out.println(setIthBit(n,i));
    }
    static int setIthBit(int n,int i){
         int result = (n|(1<<i));
         return result;
    }
}

/*Both take O(1) time and O(1) auxiliary space. */