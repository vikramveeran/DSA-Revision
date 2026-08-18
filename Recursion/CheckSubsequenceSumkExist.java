public class CheckSubsequenceSumkExist {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int K = 3;
        boolean answer = existsSubsequence(arr, 0, 0, K);

System.out.println(answer);
    }
    static boolean existsSubsequence(int[] arr, int index, int currentSum, int K) {

    // Base case
    if (index == arr.length) {
        return currentSum == K;
    }

    
    boolean pick = existsSubsequence(
        arr,
        index + 1,
        currentSum + arr[index],
        K
    );

    
    if (pick) {
        return true;
    }

    boolean notPick = existsSubsequence(
        arr,
        index + 1,
        currentSum,
        K
    );

    return notPick;
}
}


//  Time Complexity ⏱️
// For every element, we have 2 choices:

// Include
// Exclude

// For n elements, the recursion tree has:

// 2ⁿ

// Space Complexity 💾
// The recursion goes one level deeper for every element.

// For example:

// index 0
//    ↓
// index 1
//    ↓
// index 2
//    ↓
// index 3

// Maximum recursion depth:

// n

// Therefore:

// Space Complexity
// O(n)

// 🧠 The "Pick / Not Pick" Pattern
// Whenever the problem says something like:

// all subsequences
// all subsets
// count subsequences
// subsequence with sum K
// find whether a subsequence with sum K exists
// print subsequences satisfying a condition

// Think immediately:

// Every element has 2 choices → PICK or NOT PICK.
