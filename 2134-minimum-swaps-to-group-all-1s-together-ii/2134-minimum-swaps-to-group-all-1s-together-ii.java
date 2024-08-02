class Solution {
    public int minSwaps(int[] nums) {
        // circular array -> extend the array
        // num(1) -> window size 
        // identify 0 in window and one step forward and cal min swap req
        // minimum holes(0) present in our window
        //Min holes( zero) = total no. of 1 present in array - max no. of onepresent in window
        int n = nums.length; // length of array
        int one =0;
        for(int i= 0; i<n; i++){
            if(nums[i]==1) one++; // counting num of ones in array
        }
        int a[] = new int[2*n]; // (circular array) extended array for sliding window
        for(int i =0; i<2*n; i++){
            a[i] = nums[i%n];  // circular array filling
        }
        int ans = Integer.MIN_VALUE; // max num(1) present in window
        int currone = 0; // ones in current window
        for(int i=0; i<2*n; i++){
            if(i>=one && a[i-one]==1) currone--; // small window size and last leaving ele if 1 
            if(a[i] == 1) currone ++;
            ans  = Math.max(ans, currone);
        }
        return one - ans;
    }
}