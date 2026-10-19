public class MaxSlidingWindow {
    public static void main(String[] args) {
        
    }
    static int[] maxSlidingWindow(int[] nums,int k){
          int n = nums.length;
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            output[i] = maxi;
        }

        return output;
    }
}

/*⏱️ Time Complexity: O((n - k + 1) × k) → O(n × k)

Your outer loop:

for (int i = 0; i <= n - k; i++)

Runs n - k + 1 times.

Your inner loop:

for (int j = i; j < i + k; j++)

Runs k times for each outer loop iteration.

Therefore:

TC=O((n−k+1)×k)=
O(nk)
	​
 */