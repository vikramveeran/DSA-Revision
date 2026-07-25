class ReverseEveryWord{
    public static void main(String[] args) {
        String s = "amazing coding skills";
        System.out.println(reverseWord(s));
    }
  

    static String reverseWord(String s){
        String word = " ";
        String reverse = " ";
          for(int i=0; i<=s.length()-1; i++){
                 if(s.charAt(i) == ' ' ){
                    reverse =  word+ reverse;
                    word = " ";
                 }
                 else{
                    word += s.charAt(i);
                     if (i == s.length() - 1) {
                    reverse = word + reverse;
                }
                 }
          }
          return reverse;
    } 
}