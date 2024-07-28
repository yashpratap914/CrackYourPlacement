class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        // a+b+c =0
        // b+c = 0-a
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            //duplicate a
            if(i==0 || nums[i-1]!=nums[i]){ // either first ele or adjacent ele not equal
                twoSum(nums, i+1, nums.length-1, 0-nums[i]);
            }
        }
        return res;
    }
    void twoSum(int[] nums, int i, int j, int target){
        int a1 = nums[i-1]; // first ele
        while(i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(a1);
                list.add(nums[i]); // b
                list.add(nums[j]); // c
                
                res.add(list);
                
                //duplicate b
                while(i<j && nums[i]==nums[i+1])i++;//adjacent ele equal skip that element
                
                //duplicate c
                while(i<j && nums[j]==nums[j-1])j--;//adjacent ele equal skip that element
                
                i++;
                j--;
            }
        }
        
    }
}