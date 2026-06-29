public class NextPermutatiion {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int[] result = nextPermutation(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(result[i]);
        }
    }
    static int[] nextPermutation(int[] arr){
        int index = -1;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] <arr[i+1]){
                index = i;
                break;
            }
        }
            if (index == -1) {
                reverse(arr, 0, arr.length - 1);
            return arr;
        }
        for(int i=arr.length-1; i>index; i++){
            if(arr[i] > arr[index]){
                swap(arr,i,index);
                break;
            }
        }
        reverse(arr,index+1,arr.length-1);
        return arr;        
    }
    static void reverse(int[] arr,int start,int end){
            while(start<end){
               swap(arr,start,end);
               start++;
               end--;
            }
        }
      static  private void swap(int[] arr,int i, int j){
             int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
        }
}

/*Time Complexity: O(N), we find the breaking point and reverse the subarray in linear time.
Space Complexity: O(1), constant additional space is used.
 */

/*Example
nums = [2, 1, 5, 4, 3, 0, 0]

We want to find the next lexicographically greater permutation.

Step 1: Find the first decreasing element from the end

Start from nums.length - 2.

i	nums[i]	nums[i+1]	nums[i] < nums[i+1]?
5	0	0	No
4	3	0	No
3	4	3	No
2	5	4	No
1	1	5	Yes

So,

index = 1

Current array:

[2, 1, 5, 4, 3, 0, 0]
     ↑
   index
Step 2: Find the smallest element greater than nums[index]

Search from the end.

Need an element greater than 1.

i	nums[i]	>1 ?
6	0	No
5	0	No
4	3	Yes

Swap nums[1] and nums[4].

After swap:

[2, 3, 5, 4, 1, 0, 0]
Step 3: Reverse the suffix

Reverse everything after index.

Suffix:

[5, 4, 1, 0, 0]

Reverse it:

[0, 0, 1, 4, 5]

Final array:

[2, 3, 0, 0, 1, 4, 5]

This is the next permutation.

Another Dry Run (Simple Example)
nums = [1,2,3]
Step 1

Find first decreasing element.

2 < 3

So

index = 1
Step 2

Find number greater than 2 from the end.

3 > 2

Swap:

[1,3,2]
Step 3

Reverse after index.

Suffix is just

[2]

No change.

Final answer:

[1,3,2]
Example when array is completely decreasing
nums = [3,2,1]
Step 1

Check:

2 < 1 ? No
3 < 2 ? No

No index found.

index = -1
Step 2

Since no greater permutation exists, reverse the whole array.

[3,2,1]
↓
[1,2,3]

This is the smallest permutation.

Why do we reverse the suffix?

After finding the pivot (index), the part to its right is already in descending order.

Example:

1 5 4 3 2
  ↑
pivot

After swapping the pivot with the next larger element:

2 5 4 3 1

The suffix (5 4 3 1) is still in descending order. To obtain the smallest arrangement greater than the original permutation, we reverse it into ascending order:

2 1 3 4 5

This guarantees the immediate next lexicographical permutation.

Time Complexity
Finding pivot: O(n)
Finding successor: O(n)
Reversing suffix: O(n)

Overall: O(n)

Space Complexity
O(1) (in-place algorithm). */