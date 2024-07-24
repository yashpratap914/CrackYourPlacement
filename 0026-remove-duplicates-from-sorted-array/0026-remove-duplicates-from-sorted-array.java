class Solution {
    public int removeDuplicates(int[] nums) {
        // 2 pointer approach
        int i =0;
        int j =0;
        
        while(i<nums.length){
            if(nums[i]==nums[j]){
                i++;
            }else{
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
        
        
    }
}