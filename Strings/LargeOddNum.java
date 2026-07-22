package Strings;

public class LargeOddNum {
    public static void main(String[] args) {
        String num = "5047";
        System.out.println(largeOddNum(num));
    }
    static String largeOddNum(String s) {
        int ind = -1;

        // Find the last odd digit in the string
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (ind == -1) return "";

        // Skip leading zeroes up to the odd digit
        i = 0;
        while (i <= ind && s.charAt(i) == '0') i++;

        // Return substring from first non-zero to odd digit
        return s.substring(i, ind + 1);
        
    }
}
