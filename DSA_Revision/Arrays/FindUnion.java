import java.util.ArrayList;
import java.util.Arrays;

public class FindUnion {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {2,3,4,4,5};
        ArrayList result = findUnion(arr1,arr2);
        System.out.println(result);
    }
    static ArrayList findUnion(int[] arr1, int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer>list = new ArrayList<>();
        int i =0;
        int j = 0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j] ){
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                           list.add(arr1[i]);
                          
                }
                i++;
            }
                else if(arr2[j] < arr1[i] ){
                if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                           list.add(arr2[j]);
                         
                } 
                 j++;
            }
            else {
            //    if 2 arrays are equal
                if (list.isEmpty() || list.get(list.size() - 1) != arr1[i])
                    list.add(arr1[i]);
              
            }
              i++; j++;  
        }
             while (i < n) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr1[i])
                list.add(arr1[i]);
                  i++;
        }
       
         while (j < m) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr2[j])
                list.add(arr2[j]);
              j++;
        }
        
        

        return list;
    }
}
/*Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct. 

Space Complexity : O(m+n) {If Space of Union ArrayList is considered} O(1) {If Space of union ArrayList is not considered} */