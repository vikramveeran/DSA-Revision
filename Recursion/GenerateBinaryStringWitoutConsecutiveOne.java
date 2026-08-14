package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateBinaryStringWitoutConsecutiveOne {
     public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
           generate(n," ",result);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
     static void generate(int n,String curr,List<String> result){
        if(curr.length() == n){
            result.add(curr);
            return;
        }

        generate(n, curr + "0", result);

        // Add '1' only if previous char is not '1'
        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            generate(n, curr + "1", result);
        }
     }
}
