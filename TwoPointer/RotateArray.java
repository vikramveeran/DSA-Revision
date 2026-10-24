package TwoPointer;

import java.util.Arrays;

public class RotateArray {
   
    public static void main(String[] args) {
         int[] array = {1,2,3,4,5,6,7,8};
         int k = 4;
         System.out.println(Arrays.toString(rotateArray(array,k)));
    }
    static int[] rotateArray(int[] array,int k){
         int l  = 0;
         int r = k;
         while(l < k){
             int temp = array[l];
             array[l]  = array[r];
             array[r] = temp;
             l++;
             r++;
         }
         return  array;
    }
}
