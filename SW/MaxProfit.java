public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        System.out.println(maxProfit(prices));
    }
    static int maxProfit(int[] prices){
        int  left = 0;
        int right = 1;
        int maxProfit = 0;
        while(right < prices.length){
             if(prices[left] < prices[right]){
                 maxProfit = Math.max(maxProfit,prices[right]-prices[left]);
                 
             }
             else{
                left = right;
             }
             right++;
        }
        return  maxProfit;
    }
}

/*Time & Space Complexity
Time complexity: 
O(n)
Space complexity: 
O(1) */
