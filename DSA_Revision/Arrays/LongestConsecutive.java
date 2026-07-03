import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        
    }

    static int longestConsecutive(int[] arr){
        HashSet<Integer>set = new HashSet<>();

                if (arr.length == 0) return 0;

        int longest = 1;

        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
       for(int it : set){
            if(set.contains(it -1)){
                int count = 1;
                int x = it;
            
            while(set.contains(x+1)){ 
                x = x+1; 
               count++;
              

            }
            longest = Math.max(longest,count);
        }
       }
       return longest;
    }
}

/*Time Complexity: O(n), where n is the number of elements in the array. This is because we traverse each element once to build the set and then again to find the longest consecutive sequence.

Space Complexity: O(n), as we use a set to store the unique elements of the array, which in the worst case can be equal to the size of the input array. */