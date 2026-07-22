package Strings;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("rotation", "tionrota"));
    }
    static boolean rotateString(String s,String goal){
        String result = s+s;
        if (s.length() != goal.length()) {
            // Return false if lengths don't match
            return false;
        }
        return result.contains(goal);
    }
}
