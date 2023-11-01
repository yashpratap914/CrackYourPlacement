class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int account : customer) {
                wealth += account;
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        
        return maxWealth;
    }
}