package binarySearch2;

public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        int h = 9;
        System.out.println(minEatingSpeed(arr,h));
    }
    static int minEatingSpeed(int[] arr, int h) { 
        int l = 1;
         int r = 0;
          for (int num : arr) {
             r = Math.max(r, num); 
            } int k = r;
             while (l <= r) { 
                int mid = l + (r - l) / 2; 
                int hours = 0; 
                for (int i = 0; i < arr.length; i++) { 
                    hours += (arr[i] + mid - 1) / mid; 
                } if (hours <= h) { 
                    k = mid; r = mid - 1; 
                } else { l = mid + 1; 

                } 
            }
             return k; 
        }
}

/*1. First, understand the variables
int l = 1;
int r = 0;

for (int num : arr) {
    r = Math.max(r, num);
}

This loop finds the maximum element in the array.

Let's define:

n = number of elements in arr
max = maximum element in arr

Finding the maximum requires checking every element.

Time Complexity: O(n)

Next, you perform binary search:

while (l <= r) {
    int mid = l + (r - l) / 2;
    int hours = 0;

    for (int i = 0; i < arr.length; i++) {
        hours += (arr[i] + mid - 1) / mid;
    }

    if (hours <= h) {
        k = mid;
        r = mid - 1;
    } else {
        l = mid + 1;
    }
}

This is where the main complexity comes from.

2. Time Complexity of Binary Search

Initially, your search range is:

l = 1;
r = max;

Therefore, the search space contains at most max possible speeds.

Every iteration halves the search space.

For example, if max = 16:

16 → 8 → 4 → 2 → 1

The number of iterations grows logarithmically with max.

Binary search: O(log max) iterations.

Remember, bro: when binary search repeatedly halves a search range of size max, its complexity is O(log max).

3. Time Complexity of the Inner Loop

Inside the binary search, you have:

for (int i = 0; i < arr.length; i++) {
    hours += (arr[i] + mid - 1) / mid;
}

Suppose your array is:

int[] arr = {1, 4, 3, 2};

The inner loop checks all four elements for every binary search iteration.

If the array contains n elements, the loop executes n times.

Therefore:

Inner loop: O(n)

4. Combine Both Complexities

This is the most important part, bro! 🔥

Your inner loop executes during every binary search iteration.

We have:

Binary search: O(log max) iterations
Inner loop: O(n) work per iteration

Multiply them:

O(log max) × O(n)

Therefore, the binary search portion takes:

O(n log max)

Now, remember that the initial loop for finding the maximum takes O(n).

The total is:

O(n) + O(n log max)

We simplify this to:

✅ Final Time Complexity: O(n log max)

Here, n is the length of the array, and max is its largest element.

We can omit the standalone O(n) term because O(n log max) dominates it for max ≥ 2.

5. Space Complexity (SC)

Look at your variables:

int l, r, mid, hours, k;

You also use the loop variable i and the variable num in the enhanced for loop.

All these variables use a fixed amount of extra memory.

You don't create another array, list, or other data structure that grows with the input size.

Therefore:

✅ Space Complexity: O(1)

Your algorithm uses constant auxiliary space.

6. Final Answer for Your DSA Notes
Complexity	Answer	Reason
Time Complexity	O(n log max)	Binary search takes O(log max) iterations, and each iteration processes all n elements.
Space Complexity	O(1)	Only a fixed number of variables are used. */