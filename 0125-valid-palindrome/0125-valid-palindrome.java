class Solution {
    public boolean isPalindrome(String s) {
        // convert string to lower case
        //must be alphanumeric
        // condition
        int p1 =0;
        int p2 = s.length()-1;
        s = s.toLowerCase();
        while(p1<p2){
            char ch1 = s.charAt(p1);
            char ch2 = s.charAt(p2);
            
            if(!(ch1>='a' && ch1<='z' || ch1>='0' && ch1<='9')){
                p1++;
                continue;
            }
            if(!(ch2>='a' && ch2<='z' || ch2>='0' && ch2<='9')){
                p2--;
                continue;
            }
            if(ch1!=ch2){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}