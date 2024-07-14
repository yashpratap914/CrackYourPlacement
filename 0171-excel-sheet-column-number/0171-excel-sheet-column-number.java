class Solution {
    public int titleToNumber(String ct) {
        int result=0;
        for(int i=0;i<ct.length();i++){
            result = result*26 + ct.charAt(i)-'A'+1;
        }
        return result;
        
    }
}