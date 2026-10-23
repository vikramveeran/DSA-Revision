package TwoPointer;

public class MergeAlternately {
    public static void main(String[] args) {
       String  word1 = "abc";
       String word2 = "xyz";
       System.out.println(mergeAlternately(word1,word2));
    }
    static String mergeAlternately(String word1, String word2){
        int l = 0;
        int r = 0;
        StringBuilder str = new StringBuilder();
         while(l < word1.length() || r < word2.length()){
            if(l <word1.length()){
                str.append(word1.charAt(l));
                l++;
            }
             
            if(r < word2.length()){
                str.append(word2.charAt(r));
                r++;
            }
            
         }
         return str.toString();
    }
}
