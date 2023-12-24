class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int index;
        
        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i=0; i<nums.length; i++){
            pairs[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(pairs);  //O(nlogn)
        
        int[] res = new int[2];
        int l=0;
        int r = pairs.length - 1;
        while(l<r){
            int left = pairs[l].val;
            int right = pairs[r].val;
            
            if(left+right<target){
                l++;
            }
            else if(left+right>target){
                r--;
            }
            else{
                res[0]=pairs[l].index;
                res[1]=pairs[r].index;
                break;
            }
        }
                    
        return res;
        
       
    }
}
    
