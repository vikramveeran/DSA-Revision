public class LongestSubarraywithSumK {
    public static void main(String[] args) {
          int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
       System.out.println(longestSubarraywithSumK(arr,k));
    }
    // twoo pointer approch
   static int longestSubarraywithSumK(int[]  arr,int k){
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int n = arr.length;
        int max = 0;
        while(right < n){
            while(left <= right && sum > k){
             sum -= arr[left];
             left++;
        }
        if(sum == k){
             max = Math.max(max,right - left+1);
        }
        right++;
        if(right < n){
           sum += arr[right];
        }
        }
       
        return max;
    }
}
/*Time Complexity: O(N), where N is the size of the array. The algorithm traverses the array once with two pointers, making it linear in time complexity.

Space Complexity: O(1), as it uses a constant amount of space. */