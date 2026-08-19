import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {
    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        int target = 7;
        List<Integer>list = new ArrayList<>();
        List<List<Integer>> Answer = combinationSum(arr,target);
        for(List<Integer> it : Answer){
             System.out.println(it);
        }
    }
    static void func(int[] arr,int target,int index,List<Integer> currentElement,List<List<Integer>>result){
        if(target == 0){
           result.add(new ArrayList<>(currentElement));
           return;
        }
        if(index == arr.length || target < 0 ){
             return;
        }
        currentElement.add(arr[index]);
        func(arr,target-arr[index],index,currentElement,result);
        currentElement.remove(currentElement.size()  -1);
        func(arr,target,index+1,currentElement,result);
    }
    static List<List<Integer>> combinationSum(int[] arr,int target){
          List<List<Integer>> result = new ArrayList<>();
         func(arr,target,0,new ArrayList<>(),result);
        return result;
    }
}

/*6. Time Complexity ⏱️
For Combination Sum, the exact complexity is somewhat output-dependent because the number of valid combinations can be large.

A commonly used upper-bound style explanation is:

Time:
O(2^T) in a simplified recursion analysis, where T is the target.

Why?
At each stage you're making choices to either:
TAKE
NOT TAKE */

/*7. Space Complexity 💾
There are two things:

Recursion stack

Maximum depth can be approximately:

target / smallest candidate

If smallest candidate is 1, depth can be target.

So auxiliary recursion space:

O(T) */

/*8. 🧠 Pattern to remember forever
This is the most important part.

When you see:

Combination Sum I

Immediately think:
                    CHOOSE
                   /      \
                TAKE     NOT TAKE
                  |          |
             SAME INDEX   NEXT INDEX
                  |
             target - value

And the code structure mentally becomes:
if target == 0
    save answer


if invalid
    return


TAKE:
    add element
    recurse with SAME index
    remove element


NOT TAKE:
    recurse with index + 1 */


