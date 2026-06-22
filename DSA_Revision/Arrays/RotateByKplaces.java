public class RotateByKplaces {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        String side = "left";
        int k = 2;
        int[] result = rotateArray(arr,k,side);

    }
    static void reverseArray(int[] arr,int start,int end){
        int temp = arr[start];
        while(start<end){
             arr[start] = arr[end];
             arr[end]  = temp;
             start++;
             end--;
         }
    }
    static int[] rotateArray(int[] arr,int k, String side){
         int n = arr.length;

        if (n == 0 || k == 0) return arr;

        k = k % n;
         if(side.equals("right")){
               reverseArray(arr,0,n-1);
                  
               reverseArray(arr,0,k-1);

               reverseArray(arr,k,n-1);
               
         }
        else if(side.equals("left")){
               reverseArray(arr,0,k-1);
                  
               reverseArray(arr,k,n-1);

               reverseArray(arr,0,n-1);
        }
        return arr;
    }
}

/*Time Complexity: O(N), We reverse parts of the array each reverse takes linear time. So total work is 3 × O(N) = O(N).

Space Complexity: O(1) All modifications are done in-place, using only a few temporary variables. */