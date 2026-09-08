public class MyPower {
    public static void main(String[] args) {
         int x = 2;
         int n = 10;
         System.out.println(power(x,n));
    }
    static int  power(int x ,int n){
         if(n == 0){
             return 0;
         }
         if(n == 1){
            return x;
         }
         if(n%2 == 0){
             return power(x*x ,n/2);
         }
         return x*power(x,n-1);
    }
    static int myPow(int x,int n){
        // if n is negative
        if(n < 0){
               return 1/power(x,n);
        }
        //positive
        return power(x,n);
    }
}

