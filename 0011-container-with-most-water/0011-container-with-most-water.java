class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length -1;
        int amt =0;
        int maxamt =0;
        while(st<end){
            if(height[st]<height[end]){
                amt = height[st]*(end - st);
                st++;
            }else{
                amt = height[end]*(end - st);
                end--;
            }
            if(amt>maxamt){
                maxamt = amt;
            }
        }
        
        return maxamt;
    }
}