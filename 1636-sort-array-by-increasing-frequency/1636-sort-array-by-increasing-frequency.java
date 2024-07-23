class Solution {
    public int[] frequencySort(int[] nums) {
        //HashMap for frequency
        //use comparator for custom sorting
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        Integer temp[] = new Integer[n];
        for(int i = 0; i<n; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(freq.get(a) == freq.get(b)){
                    return b-a; //decreasing order of element value
                }
                return freq.get(a) - freq.get(b);
            }
        });
        for(int i = 0; i<n; i++){
            nums[i] = temp[i];
        }
        return nums;
        
    }
}