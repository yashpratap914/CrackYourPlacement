class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        List<Integer> new_list = new ArrayList<Integer>();
        answer.add(new ArrayList<Integer>(new_list));
        
        int len = nums.length;
        if(len == 0) {
            return answer;
        }
        if(len == 1) {
            new_list.add(nums[0]);
            answer.add(new ArrayList<Integer>(new_list));
            return answer;
        }

        List<List<Integer>> temp = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < answer.size(); j++){
                new_list = new ArrayList<Integer>(answer.get(j));
                new_list.add(nums[i]);
                temp.add(new_list);
            }
            answer.addAll(temp);
            temp.clear();
        }
        return answer;
        
    }
}