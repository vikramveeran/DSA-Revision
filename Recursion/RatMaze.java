import java.util.ArrayList;
import java.util.List;

public class RatMaze {
    public static void main(String[] args) {
          int[][] path = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        ArrayList<String>An = findPath(path);
        for (String s : An) {
            System.out.println(s);
        }
       
      
       
    }
    static ArrayList<String> findPath(int[][] path){
        int n= path.length;
        ArrayList<String>result=  new ArrayList<>();
        if(path[0][0] == 0 || path[n-1][n-1] == 0){
             return result;
        } 
         
         boolean[][] visited = new boolean[n][n];

        helper(0,0,visited,"",path,result);
        return result;
    }

    static void helper(int row,int col,boolean[][] visited,String s,int[][] path,ArrayList<String>result){
            
         int n = path.length;

        // Base case: reached destination
        if (row == n - 1 && col == n - 1) {
            result.add(s);
            return;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // down
        if(row+1<n && path[row+1][col] == 1 && !visited[row+1][col]){
             helper(row+1,col,visited,s+"D",path,result);
        }
        // Left
        if (col - 1 >= 0 &&
            path[row][col - 1] == 1 &&
            !visited[row][col - 1]) {

            helper(row, col - 1, visited, s+"L",
                   path , result);
        }

        // Right
        if (col + 1 < n &&
            path[row][col + 1] == 1 &&
            !visited[row][col + 1]) {

            helper(row, col + 1,visited,
                   s + "R",path, result);
        }

        // Up
        if (row - 1 >= 0 &&
            path[row - 1][col] == 1 &&
            !visited[row - 1][col]) {

            helper(row - 1, col,visited,
                   s + "U",path, result);
        }

        // Backtrack: unmark current cell
        visited[row][col] = false;
    }
}
/*🧠 Pattern to remember
"Mark → 4 Directions → Recurse → Unmark"
              Current cell
                   ↓
             Mark visited
                   ↓
       ┌───────┬───────┬───────┬───────┐
       ↓       ↓       ↓       ↓
       D       L       R       U
       ↓       ↓       ↓       ↓
    recurse recurse recurse recurse
       └───────┴───────┴───────┴───────┘
                   ↓
             Unmark visited */

/*⏱️ Time Complexity
Let the grid be n × n.

There are:

n² cells

From each cell, we can potentially try 4 directions.

Because the rat can explore many different paths, the worst-case number of paths can be exponential.

A commonly used upper bound is:

O(4^(n²)) */

/*.

💾 Space Complexity
There are two things:

1. visited[][]
n × n

So:

O(n²) 
2. Recursion stack

A path can visit at most n² cells.

Therefore:

O(n²)
So auxiliary space:
O(n²)*/