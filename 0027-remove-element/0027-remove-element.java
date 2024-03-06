class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Initialize the count of elements not equal to val
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the element not equal to val to the front
                k++; // Increment the count of elements not equal to val
            }
        }
        
        return k;
        
    }
}