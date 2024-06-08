class Solution {
    public int dominantIndex(int[] nums) {
        int p =0;
        int max = Integer.MIN_VALUE;
        int usedi =0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                usedi = i;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(i!= usedi && max<2*nums[i]){
                return -1;
            }
        }
        return usedi;
        
    }
}