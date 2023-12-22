class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int zeros = 0;
        int ones = 0;
        
        // Count the number of ones
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        
        // Calculate the score for each possible split
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            
            int score = zeros + ones;
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
        
    }
}