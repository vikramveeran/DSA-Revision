import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen {
    public static void main(String[] args) {
        System.out.println(solveNQueen(4));
    }
    static List<List<String>> solveNQueen(int n){
         List<List<String>> result = new ArrayList<>();
         char[][] board = new char[n][n];
         for(int i=0; i<n; i++){
             Arrays.fill(board[i],'.');
         }

         helper(board,0,result,n);
         return result;
    } 
    static void helper(char[][] board,int row,List<List<String>> result,int n){
         if(row == n){
              List<String> solution = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
         }
         for(int col=0; col<n; col++){
             if(isSafe(board,row,col,n)){
                 board[row][col] = 'Q';
                 helper(board,row+1,result,n);
                 board[row][col] = '.';
             }
         }
    }
    static boolean isSafe(char[][] board,int row,int col,int n){
        for(int i=0;i<row; i++){
             if(board[i][col] == 'Q');
             return false;
        }
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}

/*Pattern to remember for a long time 🧠

Whenever you see a backtracking problem, ask these 4 questions:

1. What am I choosing?

N-Queens:

Column position
2. What is my level?
row
3. Is the choice valid?
isSafe()
4. What do I undo?
board[row][col] = '.';

So memorize:

BACKTRACKING

1. Choose
2. Recurse
3. Undo

For N-Queens specifically:

ROW
 ↓
TRY EVERY COLUMN
 ↓
SAFE?
 ↓
PUT Q
 ↓
NEXT ROW
 ↓
UNDO Q
 ↓
TRY NEXT COLUMN */

/*Time Complexity⌚
There are n rows.

For every row, we can try up to n columns:

n × n × n × ... 
      n times

So the basic recursion explores up to:

O(n^n)

But because isSafe() itself takes O(n), a common straightforward bound for this implementation is:

Time: O(n^(n+1))

However, for N-Queens, the tighter way to describe the backtracking search is often based on permutations, roughly O(n! · n) in practice/analysis when exploiting the fact that no two queens can share a column. */

/* space complexity
Board:

n × n

So:

O(n²)

Recursion depth:

O(n)

Result storage is separate and can be large because there can be many solutions.

So:
Auxiliary space: O(n²)
Including output: O(n · number of solutions)*/