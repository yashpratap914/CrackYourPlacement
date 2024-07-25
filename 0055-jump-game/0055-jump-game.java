class Solution {
    public boolean canJump(int[] nums) {
        //IMP GREEDY QUESTION
        int maxindex =0;
        for(int i=0; i<nums.length; i++){
            if(i>maxindex){
                return false;
            }
            int currmax = i + nums[i];
            maxindex = Math.max(currmax, maxindex);  
        }
        return true;
    }
}