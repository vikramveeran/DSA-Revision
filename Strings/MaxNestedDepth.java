public class MaxNestedDepth {
    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";
        System.out.println(maxNestedDepth(s));
    }
    static int  maxNestedDepth(String s){
        int count = 0;
        int Max = 0;
         for(int i=0; i<s.length() ;i++){
              if(s.charAt(i) == '('){
                  count++;
                   
              }
              else if(s.charAt(i) == ')'){
                 count --;
              }
             Max = Math.max(Max,count);
         }
         return Max;
    }
}
