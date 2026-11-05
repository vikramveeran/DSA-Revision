public class FindInMountainArray {
    public static void main(String[] args) {
        int[] mountainArray = {1  ,3 , 5  ,7,  4 , 2};
        System.out.println(findInMountainArray(mountainArray,4));
        
    }
    static int findInMountainArray(int[] mountainArray, int target){
        //  peak value
        //  // Search in increasing half
        // // Search in reverse(decrease) half

        int low  = 0;
         int high = mountainArray.length-1;

         int peak = findPeak(mountainArray,low,high);

          // Search in increasing half

        int first = increaseHalf(mountainArray,low,peak,target);
        if(first != -1){
            return first;
        }

        return reverseHalf(mountainArray,peak+1,high,target);

    }

    static int findPeak(int[] mountainArray,int low, int high){
         
         while(low <= high){
              int mid = (low+high)/2;
              if(mountainArray[mid] > mountainArray[low]){
                 low = mid+1;
              }
              else{
                 high = mid-1;
              }
         }
         return low;

    }

    static int increaseHalf(int[] mountainArray,int low,int high,int target){
         while(low <= high){

            int mid = (low+high)/2;
             if(mountainArray[mid] == target){
                 return mid;
             }
             else if(mountainArray[mid] < target){ 
                low = mid+1;
             }
             else{
                high = mid-1;
             }
         }
         return -1;
    }

    static int reverseHalf(int[] mountainArray,int low,int high,int target){
         while(low <= high){
            int mid = (low+high)/2;
             if(mountainArray[mid] == target){
                 return mid;
             }
             else if(mountainArray[mid] < target){ 
                high = mid-1;
             }
             else{
                low = mid+1;
             }
         }
         return -1;
    }

}
 
/*Time and Space Complexity
Operation	Complexity
Find peak	O(log N)
Ascending binary search	O(log N)
Descending binary search	O(log N)
Total	O(log N)
Auxiliary space	O(1) */


/*I used Binary Search to solve this problem in three steps.

First, I find the peak element of the mountain array using binary search.

Then, I search for the target in the increasing half using normal binary search.

If the target is not found, I search in the decreasing half using modified binary search because the elements are in descending order.

If the target is found, I return its index; otherwise, I return -1.

The time complexity is O(log n), and the space complexity is O(1).*/