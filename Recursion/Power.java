package Recursion;

public class Power {
    public static void main(String[] args) {
          double x = 2.0;
        long n = 10;
        System.out.println(Mypower(x,n));
    }
    static double power(double x,long n){
        if (n == 0) return 1.0;

        if(n==1){
            return x;
        }
           if(n%2 == 0){
             return power(x*x,n/2);
           }
            return x * power(x, n - 1);
    }
    static double Mypower(double x,long n){
         if (n < 0) {
            return 1.0 / power(x, -n);
        }
    
        return power(x, n);
    
    }
}
