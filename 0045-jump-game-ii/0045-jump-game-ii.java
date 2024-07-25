class Solution {
    public int jump(int[] nums) {
        int jumps = 0;  // num of jumps
        int currentEnd = 0; // start 
        int farthest = 0; // end
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);  // pos where it will go
            if (i == currentEnd) { 
                jumps++;  // increase jump
                currentEnd = farthest; // longest distance stored
            }
        }
        
        return jumps;
        
        
    }
}