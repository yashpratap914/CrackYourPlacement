class Solution {
    public int hammingWeight(int n) {
        int res =0;
        while(n!=0){
            int lastbit = n&1;
            if(lastbit == 1){
                res ++;
            }
            n=n>>1;
        }
        return res;
    }
}