public class CheckArrayisSorted {
    public static void main(String[] args) {
        int  arr[] = {1,2,3,4,5};
        boolean result = checkArrayisSorted(arr);
        System.out.println(result);
    }
    static boolean checkArrayisSorted(int[] arr){
         for(int i=1; i<arr.length; i++){ 
             if(arr[i] <arr[i-1]){
                 return false;
             }
         }

         return true;
    }
}
/*Time Complexity: O(N), as it checks each adjacent pair once in a single pass through the array.

Space Complexity: O(1), as it uses constant extra space regardless of input size. */