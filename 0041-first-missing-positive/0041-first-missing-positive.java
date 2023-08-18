class Solution {
    public int firstMissingPositive(int[] nums) {
        //preprocess the array
        for(int i =0; i<nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
                
            }
        }
        // marking indices
        for(int i =0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(index < nums.length && nums[index]>0){
                nums[index] = -1 * nums[index];
            }
        }
        //scan the array
        for(int i =0; i<nums.length; i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
        
        
    }
}