public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }
   static int majorityElement(int[] arr){
      int count = 0;
      int element = 0;
      int n = arr.length;
      for(int i=0; i<n; i++){
        if(count == 0){
            count = 1;
           element = arr[i];
         }
         
         else if(element == arr[i]){
            count++;
         }
         else {
             count--;
         }
      }  
      int count1 = 0;
      for(int i=0; i<n; i++){
         if(arr[i] == element){
             count++;
         } 
      }
      if(count > (n/2)){
            return element;
         }

         return -1;
      
   }
}

/*Time Complexity: O(N), where N is the size of the input array. This is because we are iterating through the array once to find the potential majority element and then again to verify it.

Space Complexity: O(1), as we are using only a constant amount of extra space. */