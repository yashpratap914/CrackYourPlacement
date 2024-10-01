class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mp = new int[k];

        // Count occurrences of each remainder
        for (int x : arr) {
            int rem = ((x % k) + k) % k; // Ensure non-negative remainder
            mp[rem]++;
        }

        // Check pairing conditions
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                // Remainder 0 must appear in even count
                if (mp[i] % 2 != 0) {
                    return false;
                }
            } else {
                // Remainders must match
                if (mp[i] != mp[k - i]) {
                    return false;
                }
            }
        }

        return true;
        
    }
}