class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //variable size sliding window
        int minwindow = Integer.MAX_VALUE; // infinity
        int currsum=0; // current sum
        
        //start 2 pointers sliding window
        int low = 0;
        int high =0;
        
        while(high < nums.length){// traversing array with high ptr
            
            currsum += nums[high]; // increasing sum including ele
            high++;
            
            while(currsum >= target){
                int currwindowsize = high - low;
                //update minimum length of window
                minwindow = Math.min(minwindow, currwindowsize);
                currsum -= nums[low]; // removing start ele to shrink the window size
                low++;
            }
            
        }
        return minwindow == Integer.MAX_VALUE ? 0 :minwindow;
    }
}