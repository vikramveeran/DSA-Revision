class FindLargestElement{
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,5,3};
       int result = largestElement(arr);
       System.out.println(result);
    }
    // optimal solution
    static int largestElement(int[] arr){
         int max = arr[0];
         for(int i=1; i<arr.length; i++){
             if( arr[i]  > max){
                max  = arr[i];
             }
         }
         return max;
    }
}

/*Time Complexity: O(N), where N is the size of the array, as we are iterating through the array once.

Space Complexity: O(1), as we are using a constant */