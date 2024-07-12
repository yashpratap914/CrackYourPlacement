class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> str = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = i;
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (left == right) {
                    str.add(String.valueOf(nums[left]));
                } else {
                    str.add(nums[left] + "->" + nums[right]);
                }
                left = i + 1;
            }
        }
        return str;
        
    }
}