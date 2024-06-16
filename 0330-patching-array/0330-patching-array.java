class Solution {
    public int minPatches(int[] nums, int n) {
        int x = 0;
        long reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            long c = curr;

            if (c <= reachable + 1) {
                reachable += curr;
            } else {
                x++;
                i--;
                long willAdd = reachable + 1;
                reachable += willAdd;
            }

            if (reachable >= n) {
                return x;
            }
        }

        while (reachable < n) {
            x++;
            long willAdd = reachable + 1;
            reachable += willAdd;
        }

        return x;
        
    }
}