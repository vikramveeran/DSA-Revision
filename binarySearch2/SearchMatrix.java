package binarySearch2;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30}};
        int target = 10;
        System.out.println(searchMatrix(matrix,target));
    }
     public static boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

/* ⏱️ Time Complexity (TC)

Bro, let's apply what you're learning about time complexity!

Your code contains:

while (l <= r) {
    int m = l + (r - l) / 2;

    // ...
}

Inside the loop, you eliminate approximately half the remaining search space during every iteration.

If the matrix contains N elements, the search space shrinks like this:

N → N/2 → N/4 → N/8 → N/16 → ... → 1

This is the same principle as ordinary Binary Search.

Therefore:

Time Complexity = O(log N)

Here, N is the total number of elements in the matrix.

Since:

N = ROWS × COLS

We can express the complexity as:

TC = O(log(ROWS × COLS))

This is the standard worst-case time complexity.

Why not O(n)?

Because we don't visit every element.

We eliminate approximately half the remaining search space in each iteration.

That's why it's O(log N), not O(N).

5. 💾 Space Complexity (SC)

Look at the variables you use:

int ROWS;
int COLS;
int l;
int r;
int m;
int row;
int col;

You use only a fixed number of variables.

You don't create another array or matrix.

Therefore:

Space Complexity = O(1) auxiliary space.

The input matrix itself doesn't count toward the auxiliary space used by your algorithm.



f an interviewer asks you to explain this solution, you can say:

"I treat the 2D matrix as a virtual 1D sorted array without actually creating a new array. 
I apply binary search using indexes from zero to the total number of elements minus one. 
I convert each middle index into a row using division by the number of columns and into a column using the modulo operator. 
Depending on the comparison with the target, I eliminate half the search space in each iteration.
The time complexity is O(log(rows × columns)), and the auxiliary space complexity is O(1)."
*/