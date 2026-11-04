public class FindMedian {
    public static void main(String[] args) {
        
    }
    static int findMedian(int num1[] , int num2[]){
           int total = num1.length+num2.length;
           int half = (total+1)/2;

           if(num2.length < num1.length){
            int[] temp =  num1;
            num1 = num2;
            num2 = temp;
           }

           int l = 0;
           int r = num1.length;

           while(l <= r){
             int i = (l+r)/2;
             int j = half - i;
             
             int num1left = i > 0 ? num1[i-1] : Integer.MIN_VALUE;
             int num1right = i < num1.length ? num1[i] : Integer.MAX_VALUE;
             int num2left = j > 0 ? num2[j-1] : Integer.MIN_VALUE;
             int num2right = j < num2.length ? num2[i] : Integer.MAX_VALUE;


             if(num1left <= num2right && num2left <= num1right){
                 if(total % 2 != 0){
                    return Math.max(num1left,num2right);
                 }
                 return (Math.max(num1left,num2left)+Math.min(num1right,num2right))/2;
             }
             else if(num1left > num2right){
                 r = i-1;
             }
             l = i+1;
           }
           return -1;
    }
}


/*Time Complexity: O(log(min(n, m)))
Where:
- n = length of nums1
- m = length of nums2
Why?
1. We first compare array lengths and swap if needed. This takes O(1).
2. Binary search is performed only on the smaller array.
3. In every iteration, we eliminate approximately half of the search space.
Therefore:

O(log(min(n, m)))
Space Complexity: O(1)
We use only a fixed number of variables (l, r, i, j, etc.). No extra array or data structure is created. */

/*Smaller array → Binary Search → Find partition → Validate partition → Calculate median. */