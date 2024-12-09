class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] maxReach = new int[n];
        boolean[] ans = new boolean[queries.length];

        int end = 0;
        for (int start = 0; start < n; start++) {
            end = Math.max(end, start);
            while (end < n - 1 && (nums[end] % 2 != nums[end + 1] % 2)) {
                end++;
            }
            maxReach[start] = end; 
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int endQuery = queries[i][1];
            ans[i] = endQuery <= maxReach[start];
        }

        return ans;
    }
}