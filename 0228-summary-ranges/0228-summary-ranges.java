class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> str = new ArrayList<>();  // Create an empty list to store the result.
    int left = 0;  // Initialize 'left' pointer to the start of the range.
    for (int i = 0; i < nums.length; i++) {  // Traverse the array with index 'i'.
        int right = i;  // Initialize 'right' pointer to the current index.
        // Check if we are at the end of the array or if the current number is not consecutive.
        if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
            // If the start and end of the range are the same, add only the number.
            if (left == right) {
                str.add(String.valueOf(nums[left]));
            } else {
                // Otherwise, add the range in the format "start->end".
                str.add(nums[left] + "->" + nums[right]);
            }
            // Move the 'left' pointer to the next potential start of the range.
            left = i + 1;
        }
    }
    return str;  // Return the list of ranges.
        
    }
}