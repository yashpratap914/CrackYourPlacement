class Solution {
    public int missingNumber(int[] nums) {
        int range = nums.length;
        int calsum =0;
        int actsum = (range*(range+1))/2;
        for(int i=0; i<range; i++){
            calsum += nums[i];
        }
        
        int missingnumber = actsum - calsum ;
        return missingnumber;
        
    }
}