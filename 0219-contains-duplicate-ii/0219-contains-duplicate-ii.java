class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store the value and its most recent index
        Map<Integer, Integer> mp = new HashMap<>();

        // Iterate through the array
        for (int currinx = 0; currinx < nums.length; currinx++) {
            // Check if the current value already exists in the HashMap
            if (mp.containsKey(nums[currinx])) {
                // Retrieve the index of the last occurrence of the current value
                int pastinx = mp.get(nums[currinx]);

                // Check if the distance between the current index and the last index is within the allowed range
                if (Math.abs(pastinx - currinx) <= k) {
                    // If the condition is met, return true
                    return true;
                }
            }

            // Update the HashMap with the current value and its index
            mp.put(nums[currinx], currinx);
        }

        // If no such pair is found, return false
        return false;
    }
}
