class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int st = 0;
        int end = nums.length-1;
        int ptr = ans.length-1;
        
        while(end>=st){
            if((nums[st]*nums[st]) > (nums[end]*nums[end])){
                ans[ptr] = nums[st]*nums[st];
                st++;
                
            }
            else{
                ans[ptr] = nums[end]*nums[end];
                end--;
            }
            
            ptr--;
        }
        return ans; 
        
        
        
    }
}