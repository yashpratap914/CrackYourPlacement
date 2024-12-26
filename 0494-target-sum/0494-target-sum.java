class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum < target) return 0;
        if((sum+target)<0 || ((sum+target) % 2) != 0) return 0;
       
        
        int tag=(target+sum)/2;
        return subsetSum(nums,tag);
        
    }
    int subsetSum(int[] nums,int x){
        int[][] dp= new int[nums.length+1][x+1];
        
        for(int i=0;i<=nums.length;i++){
              for(int j=0;j<=x;j++){
            dp[i][j]=0;
                if(j==0){
                dp[i][j]=1;
                }
            }
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=x;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }return dp[nums.length][x];
        
    }
}