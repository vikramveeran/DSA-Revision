package Recursion;
import java.util.*;
public class SubsequenceString {
     public static void main(String[] args) {
        String s = "abc";
        List<String>li  = new ArrayList<>();
        subsequenceString(0,s," ",li);
        System.out.println(li);
     }
     static void subsequenceString(int index,String s,String current,List<String> li){
          if(index == s.length()){
            li.add(current);
              return;
          }
          subsequenceString(index+1,s,current+s.charAt(index),li);
           subsequenceString(index+1,s,current,li);
     }
}    
