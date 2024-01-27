class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // Set the initial value for dp[0][0] as true, since an empty string matches an empty pattern
        dp[0][0] = true;
        
        // Handle the case when the pattern starts with '*'
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Iterate through the string and pattern to fill in the dp array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // If the characters match or the pattern has a '.', set dp[i][j] as the diagonal value
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the pattern has a '*', check the previous character in the pattern
                else if (p.charAt(j - 1) == '*') {
                    // If the previous character matches the current character in the string or the pattern has a '.', 
                    // set dp[i][j] as the value two positions to the left (zero occurrence of the preceding element)
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                    // If the previous character does not match the current character in the string, 
                    // set dp[i][j] as the value two positions to the left (zero occurrence of the preceding element)
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        
        // Return the result at the bottom right corner of the dp array
        return dp[s.length()][p.length()];
        
    }
}