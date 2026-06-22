public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3};
         moveZerosToEnd( arr);
        System.out.println(arr);
    }
    static void moveZerosToEnd(int[] arr){
        int n = arr.length;
        int j = -1;
        for(int k=0; k<arr.length; k++){
            if( arr[k] == 0){
                j=k;
                break;
            }
        }
          if (j == -1) return ;
        for(int i=j+1; i<arr.length; i++){
            if(arr[i] != 0){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;
            }
               
        }
    }
}

/*Time Complexity: O(N), we can move all zeroes to end in linear time.
Space Complexity: O(1), constant additional space is used. */