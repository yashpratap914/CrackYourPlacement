class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = k, cnt = 0;
        for (int num : nums) {
            xor ^= num;
        }
        while (xor > 0) {
            if (xor % 2 == 1) cnt++;
            xor /= 2;
        }
        return cnt;
        
    }
}