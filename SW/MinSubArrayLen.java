public class MinSubArrayLen {

```
public static void main(String[] args) {
    int[] arr = {2, 1, 5, 1, 5, 3};

    int target = 10;

    System.out.println(minSubArrayLen(arr, target));
}

static int minSubArrayLen(int[] array, int target) {
    int length = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;

    for (int right = 0; right < array.length; right++) {

        // 1. Expand the window
        sum += array[right];

        // 2. Shrink while the sum is >= target
        while (sum >= target) {

            // 3. Update minimum length
            length = Math.min(length, right - left + 1);

            // 4. Remove the leftmost element
            sum -= array[left];
            left++;
        }
    }

    // Return 0 if no valid subarray exists
    return length == Integer.MAX_VALUE ? 0 : length;
}
```

}

// EXPAND → CHECK → SHRINK → UPDATE ANSWER