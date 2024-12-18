class Solution {
    public int[] finalPrices(int[] prices) {
        int j,i;
      for( i=0;i<prices.length;i++){
        for( j=i+1;j<prices.length;j++){
            if(prices[j] <= prices[i]){
                prices[i]=prices[i]-prices[j];
                break;
            }
        }
    }
    return prices;
    }
}