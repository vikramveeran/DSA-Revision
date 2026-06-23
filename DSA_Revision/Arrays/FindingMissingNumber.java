public class FindingMissingNumber {
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }
    static int missingNum(int[] arr) {
        long n = arr.length + 1;
    
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
    
        long expSum = n * (n + 1) / 2;
    
        return (int)(expSum - sum);
    }
}
/* Time Complexity: O(N), we do two linear traversals in our array.

Space Complexity: O(1), as we are using a constant*/