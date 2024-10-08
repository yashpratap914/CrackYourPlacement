class Solution {
    public int minSwaps(String s) {
        int countSwap=0;
        for(char ch:s.toCharArray()){
            if(ch=='['){
                countSwap++;
            }
            else if(countSwap>0){
                countSwap--;
            }
        }        
        return (countSwap+1)/2;
        
    }
}