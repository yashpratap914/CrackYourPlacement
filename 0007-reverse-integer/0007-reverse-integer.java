class Solution {
    public int reverse(int x) {
        int reversed=0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        while(x!=0){
            int lastdigit = x%10;
            if(reversed > max/10 ||(reversed == max/10 && lastdigit>7)){
                return 0;
            }
            if(reversed<min/10 || (reversed == min/10 && lastdigit < -8)){
                return 0;
            }
            reversed = reversed*10+ lastdigit;
            x=x/10;
        }
        return reversed;
    }
}
//max:2147483648, min: -2147483647
//TC:O(Log n) and SC:O(1)