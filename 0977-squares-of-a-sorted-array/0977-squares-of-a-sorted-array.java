class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0, right= nums.length-1;
        int[] squared = new int[nums.length];
        int index = squared.length-1;
        while(left<=right){
            int tmp= Math.max(nums[left]*nums[left], nums[right]*nums[right]);
            squared[index--]=tmp;
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                right--;
            }else{
                left++;
            }
        }
        return squared;
        //TC-O(n) AND SC-O(n)
    }
}