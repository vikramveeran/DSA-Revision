public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[]={1,1,2,2,2,3,3};
        int result  = removeDuplicates(arr);
        for(int i=0 ;i<result;i++){

            System.out.println(arr[i]);
        }
    }
    static int removeDuplicates(int[] nums){
        int i =0;
        for(int j=1;j<nums.length;j++){
             if(nums[j] != nums[i]){
                
                i++;
                nums[i] = nums[j];
             }
        }
        return i+1;
    }
}
