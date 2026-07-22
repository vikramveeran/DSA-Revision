package Strings;

public class CheckAnagrams {
    public static void main(String[] args) {
          String Str1 = "INTEGER";  
        String Str2 = "TEGERNI";
        System.out.println(checkAnagrams(Str1,Str2));
    }
    static boolean checkAnagrams(String s,String t){
            int[] freq = new int[26];
            for(int i=0; i<s.length(); i++){
                 freq[s.charAt(i) - 'A']++;
            }
            for(int i=0; i<t.length(); i++){
                 freq[t.charAt(i) - 'A']--;
            }
            for(int i=0; i<26; i++){
                 if(freq[i] != 0){
                    return false;
                 }
            }
            return true;
    }

}
