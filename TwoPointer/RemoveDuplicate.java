package TwoPointer;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {2,10,10,30,30,30};
        System.out.println(removeDuplicate(arr));
    }
    static int removeDuplicate(int[] arr){
         int l = 1;
         for(int r=1; r<arr.length; r++){
             if(arr[r] != arr[r-1]){
                 arr[l++] = arr[r];
             }
         }
         return l;
    }
}

/*💡 Remember These 4 Steps
l = 1 → The first element is already unique.
r = 1 → Start checking from the second element.
arr[r] != arr[r-1] → If the current element differs from the previous one, it's a new unique element.
arr[l++] = arr[r] → Place the unique element at the next available position and increment l. */