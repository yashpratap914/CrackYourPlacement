class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0, right=0;
        while(right<nums.length){
            if(nums[left]!= nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
        //TC:O(n), SC: O(1)
    }
}