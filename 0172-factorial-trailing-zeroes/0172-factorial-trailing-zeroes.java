class Solution {
    public int trailingZeroes(int n) {
        //n/5+n/25+n/125+n/625 ->total trailing zeroes
        int count =0;
        for(int i =5; i<=n; i=i*5){
            count=count+n/i;
        }
        return count;
        
    }
}