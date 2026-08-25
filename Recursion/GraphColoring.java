package Recursion;

public class GraphColoring {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int m = 3;

        System.out.println(graphColoring(graph, m));
    }
    public static boolean graphColoring(int[][] graph, int m) {

        int n = graph.length;

        // color[i] = color assigned to vertex i
        int[] color = new int[n];

        return solve(0, graph, m, color);
    }
    static boolean solve(int vertex,int[][] graph,int m,int[] color){
        int n = graph.length;
         if(n == vertex){
             return true;
         }
         for (int c = 1; c <= m; c++) {

            // Check whether this color can be assigned
            if (isSafe(vertex, c, graph, color)) {

                // Choose
                color[vertex] = c;

                // Explore
                if (solve(vertex + 1, graph, m, color)) {
                    return true;
                }

                // Undo / Backtrack
                color[vertex] = 0;
            }
          
    }
    return false;
}
static boolean isSafe(int vertex, int c, int[][] graph, int[] color) {

        for (int i = 0; i < graph.length; i++) {

            // If vertex and i are connected
            // and i already has the same color
            if (graph[vertex][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }
}

/*M-Coloring Pattern
1. Pick a vertex
solve(vertex)

Start from vertex 0.

2. Try every color
for (int c = 1; c <= m; c++)

For each vertex, try colors 1 to m.

3. Check if the color is safe
if (isSafe(vertex, c, graph, color))

Check whether any adjacent vertex already has color c.

4. Choose
color[vertex] = c;

Assign the color.

5. Explore
if (solve(vertex + 1, graph, m, color)) {
    return true;
}

Move to the next vertex.

6. Undo / Backtrack
color[vertex] = 0;

If the choice didn't work, remove the color and try another color.

7. Base case
if (vertex == graph.length) {
    return true;
}

If all vertices are colored → solution found. */


/*⏱️ Time Complexity
For n vertices and m colors:

O(m^n × n)

Why?

Each of n vertices can have up to m choices → m^n
isSafe() checks up to n vertices → O(n)

Therefore:

TC = O(m^n × n) */

/*💾 Space Complexity
O(n)

Because:

color[] → O(n)
Recursion stack → O(n)

So:

SC = O(n)
Easy to remember
M-Coloring
     ↓
Backtracking
     ↓
m choices for n vertices
     ↓
O(m^n × n)

Space → O(n) */