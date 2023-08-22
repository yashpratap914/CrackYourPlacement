class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea =0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for ( int i=1; i<= heights.length; i++){
            int curr = (i == heights.length)? -1 : heights[i];
            while(!stack.isEmpty() && curr <= heights[stack.peek()])            {
                int height = heights[stack.pop()];
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                int currArea = height*width;
                maxArea= Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
        
    }
}//TC: O(n), SC:O(n)