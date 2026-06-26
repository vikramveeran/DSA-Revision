import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
         int[] arr = {1, 2, -4, -5};
         int[] result = rearrangeArrayElements(arr);
         System.out.println(Arrays.toString(result));
    }
    static int[] rearrangeArrayElements(int[] arr){
        int positive = 0;
        int negative = 1;
        int[] arr1 = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
                arr1[negative] = arr[i];
                negative +=2 ;
            }
            else{ 
               arr1[positive] = arr[i];
               positive =+2; 
            }
        }
           return arr1;
    }
}
