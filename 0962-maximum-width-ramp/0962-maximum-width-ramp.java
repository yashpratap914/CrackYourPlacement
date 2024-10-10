class Solution {
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        int len = nums.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.isEmpty() || nums[s.peek()] > nums[i]) {
                s.add(i);
            }
        }
        for (int i = len - 1; i > max; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                max = Math.max(max, i - s.pop());
            }
        }
        return max;
        
    }
}