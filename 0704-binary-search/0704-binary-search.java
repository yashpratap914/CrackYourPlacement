class Solution {
    public int search(int[] nums, int target) {
        int st =0;
        int end = nums.length - 1;
        int mid =0;
        while(st<=end){
            mid = st + (end-st) /2;
            if(target<nums[mid]){
                end = mid-1; 
            }
            else if(target>nums[mid]){
                st = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
        
    }
}