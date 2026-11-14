package LL;

public class FindDuplicate {
    public static void main(String[] args) {
        
    }
    static int findDuplicate(int[] nums){
         int slow = nums[0];
         int fast = nums[0];

         do{
             slow = nums[slow];
             fast = nums[nums[fast]];

         }
         while(slow != fast);

         slow  = nums[0];
         while(slow != fast){
             slow = nums[slow];
             fast = nums[fast];
         }
         return slow;
    }
}


// PATTERN  Floyd's Cycle Detection