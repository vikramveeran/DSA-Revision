public class PrintPrime {
    public static void main(String[] args) {
        int n = 31;
        int[] result = printPrime(n);
        for(int i=2; i<result.length; i++){
             if(result[i] == 1){
                 System.out.println(i);
             }
        }
    }

    static int[] printPrime(int n){
         int[] prime = new int[n+1];
         for(int i=2;i<=n; i++){
             prime[i] = 1;
         }
         for(int i=2; i*i<=n; i++){
             if(prime[i] == 1){
                 for(int j=2*i; j<=n; j+=i){
                     prime[j] = 0;
                 }
             }
         }
        return prime;
    }
}

/*⏱️ Time Complexity: O(n log log n)

There are two main parts:

Initialization:
for(int i = 2; i <= n; i++)
    prime[i] = 1;

→ O(n)

Sieve:
for(int i = 2; i * i <= n; i++) {
    if(prime[i] == 1) {
        for(int j = 2 * i; j <= n; j += i) {
            prime[j] = 0;
        }
    }
}

The overall sieve operation is:

O(n log log n)

So total:

O(n) + O(n log log n)
= O(n log log n)
💾 Space Complexity: O(n)

Because you create:

int[] prime = new int[n + 1];

It stores n + 1 integers.

Therefore:

Space = O(n) */