class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] right = new int[nums.length];
        int ptr = right.length-1;
        int pro =1;
        for(int i =nums.length-1; i>=0; i--){
            pro*=nums[i];
            right[i] = pro;
        }
        int left = 1;
        for(int i=0; i<ans.length-1; i++){
            int val = left*right[i+1]; 
            ans[i] = val;
            left = left * nums[i];
        }
        ans[ans.length-1]= left;
        return ans;
        
    }
    
}