class Solution {
    public int[] productExceptSelf(int[] nums) {
        //calculate prefix and suffix
        // 1 2 3 4
        // Prefix : 1 1 2 6
        // Suffix : 24 12 6 1
        // use only ans array for prefix
        int[] ans = new int[nums.length];
        //prefix
        ans[0]=1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1]*nums[i-1];
            
        }
        
        int suffix = 1;
        for(int j = nums.length-1; j>=0; j--){
            ans[j] = ans[j]*suffix;
            suffix = suffix * nums[j];
        }
        return ans;
    }
}