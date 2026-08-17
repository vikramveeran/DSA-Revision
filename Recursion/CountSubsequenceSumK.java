public class CountSubsequenceSumK{
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int target = 5;
        System.out.println(countSubsequenceWithTargetSum(nums1, target));
    }
      private static int func(int ind, int sum, int[] nums) {
        // Base case: if sum is 0, one valid
        // subsequence is found
        if (sum == 0) return 1;
        // Base case: if sum is negative or 
        // index exceeds array size
        if (sum < 0 || ind == nums.length) return 0;
        // Recurse by including current number
        // or excluding it from the sum
        return func(ind + 1, sum - nums[ind], nums) + func(ind + 1, sum, nums);
    }

    // Function to start counting subsequences
    public static int countSubsequenceWithTargetSum(int[] nums, int target) {
        return func(0, target, nums);
    }

}