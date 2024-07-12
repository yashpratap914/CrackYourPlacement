class Solution {
    public int maximumGain(String s, int x, int y) {
        // Counters for 'a' and 'b'
        int aCount = 0;
        int bCount = 0;
        
        // Determine the lesser value of x and y
        int lesser = Math.min(x, y);
        
        // Result variable to store the total points
        int result = 0;

        // Loop through the characters of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // When encountering a character greater than 'b'
            // Reset the counts and add potential points from leftover 'a' and 'b'
            if (c > 'b') {
                result += Math.min(aCount, bCount) * lesser;
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {
                // If character is 'a'
                if (x < y && bCount > 0) {
                    // If "ba" is more valuable and there's a 'b' to pair with
                    bCount--;
                    result += y;
                } else {
                    // Otherwise, increase 'a' count
                    aCount++;
                }
            } else {
                // If character is 'b'
                if (x > y && aCount > 0) {
                    // If "ab" is more valuable and there's an 'a' to pair with
                    aCount--;
                    result += x;
                } else {
                    // Otherwise, increase 'b' count
                    bCount++;
                }
            }
        }

        // Add remaining points for any leftover 'a' and 'b' pairs
        result += Math.min(aCount, bCount) * lesser;

        // Return the total points
        return result;
        
    }
}