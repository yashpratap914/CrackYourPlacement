class Solution {
    public int largestRectangleArea(int[] heights) {
        //height(given) ans width (next smaller and previous smaller) -> next smaller array and prev smaller array
        //width = upper lim - lower lim - 1
        int[] ns = findNextSmaller(heights);
        int[] ps = findPrevSmaller(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int h = heights[i];
            int w = ns[i] - ps[i] - 1;
            max = Math.max(max, (h*w));
        }
        return max;        
    }
    public int[] findPrevSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return res;
    }
    public int[] findNextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = n;
            }else{
                res[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return res;
    }
}