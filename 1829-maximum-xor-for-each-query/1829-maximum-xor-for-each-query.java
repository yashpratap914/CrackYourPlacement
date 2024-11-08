class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Create the mask with 'maximumBit' bits set to 1
        int mask = (1 << maximumBit) - 1;
        int cumulativeXor = 0;
        
        // Calculate cumulative XOR for all elements in nums
        for (int num : nums) {
            cumulativeXor ^= num;
        }
        
        // Calculate the maximum XOR for each query
        for (int i = 0; i < n; i++) {
            result[i] = cumulativeXor ^ mask; // XOR cumulativeXor with mask to get the max XOR value
            cumulativeXor ^= nums[n - 1 - i]; // Update cumulative XOR for the next query
        }
        
        return result;
        
    }
}