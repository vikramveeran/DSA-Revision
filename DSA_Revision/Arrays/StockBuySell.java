public class StockBuySell{
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(stockBuySell(arr));
    }
    static int stockBuySell(int[] arr){
         int min = Integer.MAX_VALUE;
         int maxProfit = 0;
         for(int i=0; i<arr.length; i++){
              if(  arr[i] < min){ 
                 min = arr[i];
              }
              else{
                maxProfit = Math.max(maxProfit,arr[i]-min);
              }
         }
         return maxProfit;
    }
}
