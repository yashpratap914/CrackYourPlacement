class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        
        while(numBottles >= numExchange){
            int newbot = numBottles/numExchange;
            int rembot = numBottles%numExchange;
            ans = ans + newbot;
            numBottles = newbot + rembot;
        }
        return ans;
        
    }
}