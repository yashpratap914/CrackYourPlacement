class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Create a list to hold all the permutations of the array
        List<List<Integer>> l = new ArrayList<>();
        
        // Start the backtracking process from the first index (0)
        backtrack(l, nums, 0);
        
        // Return the list of permutations
        return l;
    }
    
    // Recursive method to generate permutations using backtracking
    public void backtrack(List<List<Integer>> l, int[] nums, int start) {
        // Base case: if the start index is equal to the length of the array
        // it means a full permutation has been generated
        if (start == nums.length) {
            // Convert the current permutation (array) to a list and add to the result list
            l.add(toList(nums));
        } else {
            // Loop through the array from the current index to the end
            for (int i = start; i < nums.length; i++) {
                // Swap the current index with the start index to generate a new permutation
                swap(i, start, nums);
                
                // Recursively generate permutations for the remaining part of the array
                backtrack(l, nums, start + 1);
                
                // Swap back to restore the original array state (backtrack)
                swap(i, start, nums);
            }
        }
    }
    
    // Convert an array of integers to a list of integers
    public List<Integer> toList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        // Add each element of the array to the list
        for (int i : nums) {
            res.add(i);
        }
        
        // Return the list
        return res;
    }
    
    // Swap two elements in the array
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];  // Store the value at index i
        nums[i] = nums[j];   // Assign the value at index j to index i
        nums[j] = temp;      // Assign the stored value to index j
    } 
}
