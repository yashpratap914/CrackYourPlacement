class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        // Arrays to count occurrences of each digit in secret and guess
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        
        // First pass: count bulls and record unmatched characters
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                // Record the unmatched characters
                secretCounts[s - '0']++;
                guessCounts[g - '0']++;
            }
        }
        
        // Second pass: count cows
        for (int i = 0; i < 10; i++) {
            // The number of cows is the minimum number of unmatched characters
            // present in both secret and guess
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }
        
        // Construct the result in the required format
        return bulls + "A" + cows + "B";
        
    }
}