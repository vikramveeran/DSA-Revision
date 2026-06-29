import java.util.ArrayList;
import java.util.Collections;

public class LeaderArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> result = leaderArray(arr);
        System.out.println(result);



    }
    static ArrayList<Integer> leaderArray(int[] arr){
        ArrayList<Integer>list = new ArrayList<>();
        int max =  arr[arr.length-1];
        list.add(max);
        for(int i=arr.length-2;i>=0; i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }
         Collections.reverse(list);

         return list;
    }
}
/*Time Complexity: O(N), where N is the size of the input array. This is because we traverse the array only once.

Space Complexity: O(1), as we are using only a constant amount of extra space. */