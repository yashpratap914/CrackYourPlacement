class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
        for(int i =0; i<flowerbed.length; i++){
            if(flowerbed[i]==0){
                //closest left non empty plot of i
                int left =i;
                while(left>=0 && flowerbed[left]==0){
                    left--;
                }
                //closest right non empty plot of i
                int right=i;
                while(right< flowerbed.length && flowerbed[right] == 0){
                    right++;
                }
                if((left<0 || i-left>=2) && (right>=flowerbed.length || right-i >= 2)){
                    count++;
                    flowerbed[i] = 1;
                }
                
            }
            
        }
        return count >=n;    
    // TC- O(n^2)    : SC- O(1)     
    }
}