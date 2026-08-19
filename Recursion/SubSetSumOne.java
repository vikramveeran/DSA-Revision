import java.util.ArrayList;
import java.util.*;

public class SubSetSumOne {
    public static void main(String[] args) {
        
        int[] arr = {2, 3, 1};

        List<Integer> result = new ArrayList<>();
        
        helper(0, 0, arr, result);
        Collections.sort(result);
        System.out.println(result);
    }
    static void helper(int index,int sum,int[] arr,List<Integer> result){
          if(index == arr.length){
             result.add(sum);
             return;
          }  
          helper(index+1,sum,arr,result);
          helper(index+1,sum+arr[index],arr,result);
    }

}

/*🔥 Pattern: "Take / Not Take"

Whenever the problem says:

generate all subsets
generate all subsequences
find sum of every subset
count subsets
check whether a subset exists
find subsets with sum K

Think:

                index
               /     \
          NOT TAKE   TAKE
             |         |
          same sum   sum + arr[index]
             \         /
              index + 1 */


/* ⏱️ Time Complexity
There are 2 choices for every element:

2 × 2 × 2 × ... × 2
        n times

Therefore:

Recursion = O(2^n)

After generating the sums, you sort 2^n values.

Sorting:

O(2^n log(2^n))

which is:

O(n × 2^n)

So the overall time complexity is:

O(n × 2^n)*/

/*💾 Space Complexity
We have 2^n subset sums stored in the result:

O(2^n)

Recursion stack depth is:

O(n)

Therefore:

Total auxiliary/output space = O(2^n + n)

Usually we simplify this to:

O(2^n) */