import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
        int[] arr = {2,3,4};
        System.out.println(findClosestElements(arr,3,1));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
