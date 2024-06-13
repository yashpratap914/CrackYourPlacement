class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int num = 0;
        int tcount = 0;
        
        for(int ele : nums){
            if(ele == target){
                tcount++;
            }else if(ele<target){
                num++;
            }
        }
        
        List<Integer> l = new ArrayList<>();
        
        while(tcount>0){
            l.add(num);
            num++;
            tcount--;
        }
        return l;
    }
}