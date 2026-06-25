import java.util.HashMap;

public class LongestSubarraySumWithZero {
    public static void main(String[] args) {
         int[] arr = new int[]{9, -3, 3, -1, 6, -5};
         System.out.println(longestSubarraySumWithZero(arr));
    }
    static int longestSubarraySumWithZero(int[] arr){
        int n = arr.length;
        int sum = 0;
        int maxLength = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
 
         for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == 0){
                maxLength = i+1;
            }
            else{
                 if(map.containsKey(sum)){
                maxLength = Math.max(maxLength,i-map.get(sum)); 
             }
             else{
                 map.put(sum,i);
             }
            }
         }
         return maxLength;
    }
}
