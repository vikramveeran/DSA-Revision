import java.util.Arrays;

public class TwoSumExists {
    public static void main(String[] args) {
         int[] arr = {2,6,5,8,11};
        int target = 15;
        System.out.println(twoSumExists(arr,target));
    }
    static String twoSumExists(int[] arr,int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int sum  = 0;
        int[][] arrWithIndex = new int[n][2];
        for(int i=0; i<n; i++){
             arrWithIndex[i][0] = arr[i];
            arrWithIndex[i][1] = i; 
        }
        Arrays.sort(arrWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
       while(left < right){
         sum = arrWithIndex[left][0]+arrWithIndex[right][0];
         if(sum == target){
            return "yes";
         }
         else if(sum<target){
            left++;
         }
         else{
            right--;
         }
       }
        return "no";
    }
}


