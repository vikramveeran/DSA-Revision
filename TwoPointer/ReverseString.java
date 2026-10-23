package TwoPointer;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
       String[]  s = {"n","e","e","t"};
       System.out.println(Arrays.toString(reverseString(s)));
    }
    static String[] reverseString(String[] s){
          int l = 0, r = s.length - 1;
        while (l < r) {
            String temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
        return s;
    }
}
