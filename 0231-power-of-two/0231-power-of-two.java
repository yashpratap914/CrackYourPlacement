class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        while(n!=0){
            int lastbit = n & 1;
            n = n >> 1;
            if(lastbit == 1 && n != 0){
                return false;
            }
            
        }
        return true;
        
    }
}