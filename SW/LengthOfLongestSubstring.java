import java.util.*;
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(str));
    }
    static int lengthOfLongestSubstring(String str){
        HashMap<Character,Integer>maxF = new HashMap<>();
         int length = 0;
         int Max = 0;
         for(int i=0; i<str.length(); i++){
              if(maxF.containsKey(str.charAt(i))){
                   length = Math.max(maxF.get(str.charAt(i)) + 1, length);
              }
              else{
                maxF.put(str.charAt(i),i);
                Max = Math.max(str.charAt(i),i-length+1);
              }
         }
         return Max;
    }
}



