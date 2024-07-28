class Solution {
    public int maxArea(int[] height) {
        int st = 0; //start line
        int end = height.length -1; // end line
        int amt =0; // amount 
        int maxamt =0; // maximum amount
        while(st<end){ // two pointer approach
            if(height[st]<height[end]){  //height(start line) < height(end line)
                amt = height[st]*(end - st); // area -> amount-> [width(end - start) * min(height)]
                st++; //to increase height of start line -> maximise amount
            }else{
                amt = height[end]*(end - st); // if height(end line) is less
                end--; // to increase height of end line -> maximise amount
            }
            if(amt>maxamt){ // new amount compared and replaced if more
                maxamt = amt;
            }
        }
        
        return maxamt;
        
    }
}