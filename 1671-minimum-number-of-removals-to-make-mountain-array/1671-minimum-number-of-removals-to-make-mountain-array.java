class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // memoization for forward direction
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        
        // memoizationfor backward direction
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        
        //find the Longest increasing subsequence in Forward Direction
        for (int cur=1;cur<n;cur++){
            for (int prev=0;prev<cur;prev++){
                if (nums[prev] < nums[cur] && (1 + dp1[prev] > dp1[cur])){
                    dp1[cur] = 1 + dp1[prev];
                }
            }
        }
        
        // find the longest increasing subsequence in backward direction
        for (int cur=n-1;cur>=0;cur--){
            for (int prev=n-1;prev>cur;prev--){
                if (nums[prev] < nums[cur] && (1 + dp2[prev] > dp2[cur])){
                    dp2[cur] = 1 + dp2[prev]; 
                }
            }
        }
        // find the max no. of element which is included for making the mountain
        
        int maxi = 0;
        for (int i=0;i<n;i++){
            if(dp1[i] > 1 && dp2[i] > 1) // if this ith elemenet is single then dont consider in the longest bitonic subsequence
            maxi = Math.max(maxi,dp1[i]+dp2[i]-1);
        }
        
        return n - maxi;
        
    }
}