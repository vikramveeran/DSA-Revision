public class WordSearch {
    public static void main(String[] args) {
         char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
    static boolean exist(char[][] board,String word ){
        int row = board.length;
        int col = board[0].length;

        for(int i=0; i<row;i++){
             for(int j=0; j<col; j++){
                 if(dfs(board,word,i,j,0)){
                     return true;
                 }
             }
        }
        return false;
    }
    static boolean dfs(char[][] board,String word,int i,int j,int index ){
        if(index == word.length() ){
             return true;
        }
        if(i<0 || j<0 || i>board.length || j>board.length || board[i][j]  != word.charAt(index)){
             return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Restore character
        board[i][j] = temp;

        return found;
    }
}


/*🧠 Pattern to remember forever
1. Start from every cell

The word can begin anywhere:

for every cell:
    try DFS
2. DFS has 3 things

Think:

DFS(row, col, index)
row, col → where am I?
index → which character of the word am I looking for?
3. Check failure first

Ask:

"Can I use this cell?"

Outside grid?        → false
Wrong character?     → false
Already visited?     → false
4. Check success
index == word.length()
        ↓
      true

Meaning:

I matched every character → DONE.

5. Choose

Save the original character:

char original = board[row][col];

Then mark visited:

board[row][col] = '#';

Think:

"I'm using this cell right now."

6. Explore 4 directions
        UP
         ↑
LEFT ← current → RIGHT
         ↓
       DOWN

So:

up
down
left
right

with:

index + 1

because you've matched the current character.

7. Undo 🔥

This is the key backtracking step:

board[row][col] = original;

Think:

"This path is finished. Give the cell back." */

/*⏱️ Time Complexity

Let:

m = number of rows
n = number of columns
L = length of the word

We can start from any of the:

m × n

cells.

For each cell, we can explore up to 4 directions.

But after the first move, we cannot immediately go back to the cell we just came from, so roughly 3 choices remain at each subsequent step.

Therefore:

O(m × n × 4 × 3^(L-1))

Usually written as:

O(m × n × 3^L)
Why 3^L?

Because:

First character → up to 4 choices
Next characters → up to 3 choices

So approximately:

4 × 3 × 3 × 3 × ... 
      ↑
     L-1 times

Hence:
O(m × n × 3^L) */

/*
💾 Space Complexity
The recursion can go as deep as the length of the word:

A → B → C → D → E → ...

So recursion stack:

O(L)

We are also modifying the board in-place to mark visited cells, so we don't need a separate visited[][] array.

Therefore:

Space = O(L) */