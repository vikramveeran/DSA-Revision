package binarySearch2;

public class ShipWithinDays {
    public static void main(String[] args) {
        
    }
    static int shipWithinDays(int[] weights,int days){
        int low = 0;
        int high = 0;
         for(int w  : weights){
             low =  Math.max(low,w);
             high += w; 
         }
         while(low < high){
             int mid  = low+(high-low)/2;
             int requiredDays = 1;
             int load = 0;
             for(int w : weights){
                  if(load+w > mid){
                       requiredDays +=1;
                       load = 0;
                  }
                  load += w;
             }
             if(requiredDays <= days){
                 high = mid-1;
             }
             else{
                 low = mid+1;
             }
         }
         return low;
    }
}

/*tc => 0(nlogn) */

/* I used Binary Search on Answer to find the minimum ship capacity required to ship all packages within the given number of days.

First, I calculate the minimum possible capacity, which is the maximum weight of a single package, and the maximum possible capacity, which is the sum of all package weights.

Then I apply binary search between these two values.

For every middle capacity, I simulate the shipping process and calculate how many days are required.

If the required days are within the given limit, I try a smaller capacity. Otherwise, I increase the capacity.

Finally, I return the minimum valid capacity.
*/