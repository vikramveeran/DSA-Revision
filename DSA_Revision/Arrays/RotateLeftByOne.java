import java.util.Arrays;

public class RotateLeftByOne {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 6};
        int[] result = rotateLeftByOne(arr);
        System.out.println(Arrays.toString(result));
    }
    static int[] rotateLeftByOne(int[] arr){
        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
             arr[i-1] = arr[i];

        }
        arr[arr.length-1] = temp;
        return arr;
    } 
}
/*Time Complexity: O(N), where N is the size of the input array. This is because we traverse the array once to shift the elements.

Space Complexity: O(1), as we are using only a constant amount of extra space for the temporary variable.

 */