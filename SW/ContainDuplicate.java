import java.util.*;
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] array = {1,2,3,1};
        int k =3;
        System.out.println(containsNearbyDuplicate(array,k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

}
