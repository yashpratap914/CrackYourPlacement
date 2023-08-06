class Solution {
    public boolean isPalindrome(int x) {
        //if num is negative num
        //if the num end with 0 except the number zero
        if(x<0 || (x != 0 && x%10==0)){
            return false;
        }
        int reverse=0;
        int num = x;
        while(num>reverse){
            int lastdigit = num%10;
            reverse = reverse*10 + lastdigit;
            num = num/10;
            
        }
        return num == reverse/10 || num == reverse;
        
    }
}
/* x=121 last dig = 1 , rev=1 num=12
ld=2 rev = 12 num =1 */
