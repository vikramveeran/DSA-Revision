package BitManupulation;

public class CountNoOfSet {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(countNoOfSet(n));
    }
    static int countNoOfSet(int n){ 
        int count = 0;
        while(n != 0){
            n  = (n&(n-1));  // it will  start from the rightmost set
             count++;
             
        }
        return count;
    }
}
/*⏱️ Time Complexity

TC = O(k)

where k = number of set bits (1s) in n.

Why?
Each execution of:

n = n & (n - 1);

removes exactly one set bit.

For example:

n = 12 = 1100

1100 → 1000 → 0000
        ↑       ↑
      1 set   2 set bits total

So the loop runs exactly 2 times.

Worst Case

For a 32-bit int, maximum set bits = 32.

Therefore:

Worst-case TC = O(32) = O(1)

If considering a general number with N bits:

TC = O(N)
💾 Space Complexity

You only use:

int count
int n

No extra data structure is used.

SC = O(1)

Interview Answer

Time Complexity: O(k), where k is the number of set bits.
Space Complexity: O(1).
The algorithm is efficient because n & (n - 1) removes one set bit in every iteration. */

