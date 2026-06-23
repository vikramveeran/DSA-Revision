public class MaxConsecutiveOnes {
    public static void main(String[] args) {
            int[] nums = {1, 1, 0, 1, 1, 1};
            int result = maxCosecutiveOnes(nums);
            System.out.println(result);
    }
    static int maxCosecutiveOnes(int[] arr){
        int max = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
            }
            else {
                count = 0;
            }
            max  = Math.max(max,count);
        }

        return max;
    }
}
/*Tim