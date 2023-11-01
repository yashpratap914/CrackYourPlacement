class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = n;
        
        for (int k = 0; k < n; k++) {
            result[k * 2] = nums[i];
            i++;
            result[k * 2 + 1] = nums[j];
            j++;
        }
        
        return result;
        
    }
}