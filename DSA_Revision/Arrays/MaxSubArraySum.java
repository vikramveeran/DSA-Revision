public class MaxSubArraySum {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArraySum(arr));
    }
    static int maxSubArraySum(int[] arr){
        long max = Long.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum > max){
                max = sum;
            }
            if (sum < 0) {
                sum = 0; 
            }
        }
           return (int) max;
    }
}

