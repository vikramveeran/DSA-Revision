public class PascalTriangle{
   public static void main(String[] args) {
    
   }
   static int pascalTriangle( int r,int c){
       int n = r-1;
       int k = c-1;
       int result = 1;
       for(int i=0; i<k; i++){
            result *= (n-i);
            result /= (i+1);
               }
              return result; 
   }
}

/*Time Complexity: O(min(c,r−c)), The loop runs for min(c−1,r−c) iterations because binomial coefficients are symmetric.
Space Complexity: O(1), constant additional space is used. */