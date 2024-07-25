class Solution {
    public int maxProfit(int[] prices) {
        //compare with next element and find difference
        //add difference to result
        //ultimately its best deal done
        int profit =0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}