class Solution {
    public String convertToTitle(int col) {
        StringBuilder sb = new StringBuilder();
        
        while(col>0){// 28(say)  | 1(SECOND)
            int r = (col-1)%26; // (28-1)%26 -> 1 | 0
            sb.append((char)(r+'A')); // ('1'+'A')->'B'  | ('0'+'A')-> 'A'  |=> 'BA'
            col=(col-1)/26; // (28-1)/26 -> 1 | 0
        }
        return sb.reverse().toString();  //('BA')-->'AB'
        
    }
}