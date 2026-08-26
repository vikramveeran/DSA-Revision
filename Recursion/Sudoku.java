package Recursion;

public class Sudoku {
    public static void main(String[] args) {
         char[][] board = {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println(solve(board));
    }
    static boolean solve(char[][] board){
         for(int row=0; row<9;row++){
            for(int col=0;col<9;col++){
                 if(board[row][col] == '.'){
                     for(char num ='1';num<='9';num++){
                         if(isSafe(board,row,col,num)){
                             board[row][col] = num;
                             
                             if(solve(board)){
                                return true;
                             }
                             board[row][col] = '.';
                         }
                     }
                     return false;
                 }
            }
         }
         return true;
    }
    static boolean isSafe(char[][] board,int row,int col,char num){
         //check rows
         for(int i=0;i<9; i++){
             if(board[row][i] == num){
                return false;
             }
         }
        //  check col
         for(int j=0;j<9; j++){
             if(board[j][col] == num){
                return false;
             }
         }
    //    check box
         int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;

    }
}

/*🧠 Remember this pattern
For Sudoku, remember:

Find → Try → Check → Place → Recurse → Undo

Find empty cell
      ↓
Try 1 to 9
      ↓
   Is Safe?
    /   \
  No     Yes
  ↓       ↓
Next    Place
          ↓
       Recurse
        /   \
      Yes    No
       ↓      ↓
     Done    Undo */

/*⏱️ Time Complexity
There are at most 81 empty cells.

For each cell, we can try 9 numbers.

In the worst case:

O(9^81)

So:

TC = O(9^81)
This is the theoretical worst case. In practice,
 isSafe() also checks a maximum of 9 row + 9 column + 9 box cells,
  which is constant work, so it doesn't change the big-O expression. */


/*💾 Space Complexity
The recursion can go as deep as 81 cells.

SC = O(81)
   = O(1)

Since Sudoku always has a fixed 9×9 board. */