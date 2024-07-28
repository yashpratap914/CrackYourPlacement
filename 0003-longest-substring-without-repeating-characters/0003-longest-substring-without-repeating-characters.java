class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window technique
        // use set to make sure that no unique character presence
        //move left pointer until the duplicate is removed from left
        int left = 0;
        int right =0;
        HashSet<Character> seen = new HashSet<>();
        int maxwindow = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(seen.add(c)){
                maxwindow = Math.max(maxwindow, right-left+1);
                right++;
                
            }else{
                while(s.charAt(left)!=c){ //chars before dup char
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;// remove that dup char
            }
            
        }
        return maxwindow;
        
    }
}