import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerSet(arr));

    }
    static  List<List<Integer>> powerSet(int[] arr){
        int n = arr.length;
        int subsets = 1<<n;
         List<List<Integer>> ans = new ArrayList<>();

         for(int i=0; i<subsets; i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0; j<n; j++){
                 if((i& (1 << j)) != 0){
                     subset.add(arr[j]);
                 }
            }
          ans.add(subset);
         }
         return ans;
    }
}

/*Time Complexity

There are:

1 << n

subsets, which is 2^n.

For every subset, you check all n elements.

So:

TC = O(n × 2ⁿ)

Space Complexity

The result itself contains 2ⁿ subsets, and storing all of them requires:

SC = O(n × 2ⁿ)

because across all subsets, the total number of stored elements is proportional to n × 2ⁿ.

Also, your temporary subset uses O(n) space, but the output dominates it.

Final
Time Complexity  = O(n × 2ⁿ)
Space Complexity = O(n × 2ⁿ) */
