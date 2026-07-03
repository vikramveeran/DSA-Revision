import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
          int[] arr = {3, 1, 2, 4};

        int k = 6;

        int result = sumArraySum(arr,k);
        System.out.println(result);
    }

    //prefixum method
    static int sumArraySum(int[] arr,int k){
        HashMap<Integer,Integer>prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        int prefixSum = 0;

        int count = 0;
        for(int i=0; i<arr.length; i++){
             prefixSum += arr[i];
             int remove = prefixSum - k;
             if(prefixSumCount.containsKey(remove)){
                count += prefixSumCount.get(remove);
             }
           prefixSumCount.put(prefixSum,prefixSumCount.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
