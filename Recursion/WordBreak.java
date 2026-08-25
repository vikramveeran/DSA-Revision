package Recursion;

import java.util.ArrayList;

public class WordBreak {
    public static void main(String[] args) {
       String s = "leetcode";
       ArrayList<String> wordDict = new ArrayList<>();
       wordDict.add("leet");
       wordDict.add("code");
       System.out.println(wordBreak(s,wordDict));
    }
    static boolean wordBreak(String s,ArrayList<String>wordDict){
         return helper(s, 0,wordDict);
    }
    static boolean helper(String s,int index,ArrayList<String>wordDict){
        if(index == s.length()){
             return true;
        }
        for(int end = index+1;end<=s.length(); end++){
             String word = s.substring(index,end);
             if(wordDict.contains(word)){
                 if(helper(s, end, wordDict)){
                    return true;
                 }
             }
        }
        return false;
    }
}

/*🧠 Pattern to Remember
"Start → Try → Check → Recurse → Backtrack"
index
  ↓
Try every substring
  ↓
Is substring in dictionary?
  ↓ YES
Recursively solve remaining string
  ↓
index == n ?
  ↓
true
*/

/*⏱️ Time Complexity
For the plain recursive solution, worst case is approximately:

O(2ⁿ × n)

Why?

There can be exponentially many ways to split the string → O(2ⁿ)
Creating/checking substrings can cost up to O(n)
wordDict.contains() on an ArrayList can itself take O(D) where D is the number of dictionary words.

So for interview/DSA purposes, you can remember:

Recursive Word Break = Exponential time, roughly O(2ⁿ)

If using a HashSet for the dictionary and accounting for substring costs, the bound can vary, but exponential is the key point.

💾 Space Complexity
O(n)

Because the deepest recursion can go up to n calls:

helper(0)
   ↓
helper(1)
   ↓
helper(2)
   ↓
...
helper(n)

So recursion stack:

O(n) */