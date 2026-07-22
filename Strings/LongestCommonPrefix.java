package Strings;
import java.util.Arrays;
import java.util.*;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String str[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
    }
    static String longestCommonPrefix(String[] str){
        StringBuilder ans = new StringBuilder();
         Arrays.sort(str);

         String firstString = str[0];
         String lastString = str[str.length-1];
         for(int i=0; i<Math.min(firstString.length(),lastString.length()); i++){
              if(firstString.charAt(i) != lastString.charAt(i)){
                    return ans.toString();
              }
              ans.append(firstString.charAt(i));
         }
         return ans.toString();
    }
}
