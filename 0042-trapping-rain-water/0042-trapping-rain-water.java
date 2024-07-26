class Solution {
    public int trap(int[] height) { // 3 1 2 4 0 1 3 2
        //making auxilary arr left having (max val from lhs)-> highest bar 
        int[] left = new int[height.length]; // 3 3 3 4 4 4 4 4
        
        //making auxilary arr right having max (val from rhs) -> highest bar 
        int[] right = new int[height.length]; // 4 4 4 4 3 3 3 2
        
        left[0] = height[0];  // for left array

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[height.length - 1] = height[height.length - 1]; // for right array
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        int sum =0;
        
        for(int i=0; i<height.length; i++){
            sum += ( Math.min(left[i],right[i])-height[i]); //minimum of left and right while subtracting height
        }
        return sum; // amount of water collected
        
    }
}