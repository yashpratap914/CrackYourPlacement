class Solution {
    public int removeElement(int[] nums, int val) {
        int st = 0;
        int end = nums.length -1;
        
        while(st<=end){
            if(nums[end]==val){
                end--;
            }
            else if(nums[st]==val){
                int temp = nums[end];
                nums[end]=nums[st];
                nums[st]=temp;
                st++;
                end--;
            }
            else{
                st++;
                
            }
            
        }
        int r = end+1;
        return r;
    }
}