class Solution {
    public int removeDuplicates(int[] nums) {     
        

        int i=0;
        for(int n: nums){
            if((i<2)||n!=nums[i-2]){ // if less than 2 or not equal to last to last ele 
                nums[i++]=n;
            }
        }
        return i;
    }
}