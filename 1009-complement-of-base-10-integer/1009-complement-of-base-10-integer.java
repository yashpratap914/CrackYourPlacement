class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int num =n; //copy of n
        int mask =0;
        
        while(num != 0){
            mask = mask << 1 | 1;
            num = num >> 1;
        }
        
        return (~n) & mask;
        
    }
}