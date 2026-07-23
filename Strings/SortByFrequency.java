import java.util.*;
import java.util.stream.Collectors;

class SortByFrequency{
    public static void main(String[] args) {
       String s = "tree";
        System.out.println(sortByFrequency(s));
    }
    static List<Character> sortByFrequency(String s){
        HashMap<Character,Integer>map  = new HashMap<>();
          for(int i=0; i<s.length(); i++){
              map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

          }
        List<Character> sortedChars = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue()) // Use .reversed() (.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())))here for descending
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

             return sortedChars;
        }
       
    
}

/*Complexity	Result
Time	O(n + k log k)
Space	O(k) */
