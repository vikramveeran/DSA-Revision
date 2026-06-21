public class SecondLargest {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 7, 7, 5};
        int result = secondLargest(arr);
        System.out.println(result);
    }
    static int secondLargest(int[] arr){
        //  edgecase
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
         if(n<2){
             return-1;
         }
         for(int i=0; i<n; i++){ 
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLargest && arr[i] != largest ){
                secondLargest = arr[i];
            }
         }  
         return secondLargest;
    }
}
/*Time Complexity: O(N), we do two linear traversals in our array.

Space Complexity: O(1), as we are using a constant */