class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int st = 1;
        int end = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(end<nums[i]){
                end = nums[i];
            }
        }
        
        int ans = -1;
        
        while(st<=end){
            int mid = st+ (end - st)/2;
            if(isdivokay(nums, mid, threshold)){
                ans = mid;
                end = mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;   
    }
    
    boolean isdivokay(int[] nums, int div, int threshold){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += (int) Math.ceil((double) nums[i] / div);        
            if(sum>threshold){
                return false;
            }
        }
        return true;
    }
}