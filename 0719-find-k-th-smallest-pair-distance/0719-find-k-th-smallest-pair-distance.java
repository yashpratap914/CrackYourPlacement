class Solution {
    private int helper(int[] nums, int mid, int n) {
        int total = 0;
        for (int right = 0, left = 0; right < n; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            total += (right - left);
        }
        return total;
    }

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (helper(nums, mid, n) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}