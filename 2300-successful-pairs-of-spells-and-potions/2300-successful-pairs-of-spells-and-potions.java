class Solution {
    
    public int search(int[] nums, long target, long sel) {
        int start = 0;
        int finish = nums.length - 1;
        int med;
        if (target < nums[start] * sel) return start;
        if (target > nums[finish] * sel) return nums.length;

        while (start < finish && nums[start] < nums[finish])
        {
            if (target == nums[start] * sel) return start;
            med = (start + finish) / 2;
            if (target > nums[med] * sel)
                start = med + 1;
            else
                finish = med;

        }
        if (nums[start] * sel == target) return start;
        if (nums[start] * sel < target)
            return start + 1;
        else
            return start;
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        Arrays.sort(potions);
        int [] answ = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            if (!dict.containsKey(spells[i]))
                dict.put(spells[i], potions.length - search(potions, success, spells[i]));
            answ[i] = dict.get(spells[i]);
        }
        return answ;
        
        
    }
}