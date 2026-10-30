public class FindMin {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
    }
    static int findMin(int[] nums){
         int low = 0;
          int high = nums.length-1;
          while(low < high){
             int mid  = low+(high-low)/2;
             if(nums[mid] > nums[high]){
                 low = mid+1;
             }
             else{
                high = mid;
             }
          }
          return nums[low];
    }
    
}

/*I used Binary Search on Answer to find the minimum ship capacity required to ship all packages within the given number of days.

First, I calculate the minimum possible capacity, which is the maximum weight of a single package, and the maximum possible capacity, which is the sum of all package weights.

Then I apply binary search between these two values.

For every middle capacity, I simulate the shipping process and calculate how many days are required.

If the required days are within the given limit, I try a smaller capacity. Otherwise, I increase the capacity.

Finally, I return the minimum valid capacity.
 */
