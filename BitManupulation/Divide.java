package BitManupulation;

public class Divide {
    public static void main(String[] args) {
        int dividend = 22;
        int divisor = 3;
        System.out.println(divide(dividend,divisor));
    }
    static int divide(int dividend , int divisor){
           // Base case
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;

        
        boolean isPositive = true;
        
        if (dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;

        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);

        int ans = 0;
        while(n >= d){
             int count = 0;
             while(n >= (d<<count)){  //(d<<count++) -> d*2^count++
                 count++;
             }
             count--;
             ans += 1<<count;   //2^count
             n  -= d<<count;
        }
        if (ans > Integer.MAX_VALUE && isPositive) 
            return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;
        
    
        return isPositive ? (int)ans : (int)(-1 * ans);
    }
    
}

/*⏱️ Time Complexity

TC = O(log² n)

Why?

There are two nested loops.

while (n >= d) {              // Outer loop
    int count = 0;

    while (n >= (d << count)) { // Inner loop
        count++;
    }

    ...
}
Inner loop → O(log n) because d << count keeps doubling.
Outer loop → at most O(log n) iterations because you repeatedly subtract the largest power-of-2 multiple of d.

Therefore:

O(log n) × O(log n)
= O(log² n)
💾 Space Complexity

You only use a few variables:

n
d
count
ans
isPositive

No array, recursion, or extra data structure.

SC = O(1)

Interview answer

Time Complexity: O(log² n)
Space Complexity: O(1) */