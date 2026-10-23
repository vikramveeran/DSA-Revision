package TwoPointer;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] array1= {10,20,30,40,0,0};
        int[] array2 = {1,2};
        int m = 4;
        int n = 2;
        System.out.println(Arrays.toString(merge(array1,m,array2,n)));
    }
    static int[] merge(int[] array1, int m,int[] array2,int n){
         int last = m+n-1;
         int l = m-1;
         int r = n-1;
         while(r>=0){
              if(l >= 0 && array1[l] > array2[r]){
                array1[last--] = array1[l--];

              }
              else{
                array1[last--] = array2[r--];
              }
                 
              
         }
         return array1;

    }
}

/*1. Time Complexity (TC)

O(m + n)

l starts at m - 1, pointing to the last valid element of array1.
r starts at n - 1, pointing to the last element of array2.
last starts at m + n - 1, pointing to the last position of array1.
Each iteration places one element in its correct position.
Each pointer moves only backward, so every element is processed at most once.

Therefore, TC = O(m + n).

2. Space Complexity (SC)

O(1) — Auxiliary Space

You are modifying array1 directly.
You are not creating another array to store the merged result.
You use only three integer pointers: l, r, and last.

Therefore, SC = O(1).

Note: The returned array is the modified input array, so it doesn't count as additional space.

3. Pattern to Remember 🧠
Pattern: Two Pointers + Merge from the End */