import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) {
            return ""; // If t is longer than s, return an empty string
        }
        
        HashMap<Character, Integer> mp = new HashMap<>(); // Map to store character frequencies of t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1); // Add character frequency to map
        }

        int reqcount = t.length(); // Total characters required
        int i = 0, j = 0;
        int minwindowsize = Integer.MAX_VALUE; // Initialize the minimum window size
        int start_i = 0; // Start index of the minimum window

        while (j < n) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch)) { // Check if character is in the map
                if (mp.get(ch) > 0) {
                    reqcount--; // Decrease the required count
                }
                mp.put(ch, mp.get(ch) - 1); // Decrease frequency in the map
            }
            
            while (reqcount == 0) { // All characters matched
                int currwindowsize = j - i + 1;
                if (minwindowsize > currwindowsize) { // Update minimum window size
                    minwindowsize = currwindowsize;
                    start_i = i; // Update start index
                }
                
                char startChar = s.charAt(i);
                if (mp.containsKey(startChar)) { // Check if startChar is in the map
                    mp.put(startChar, mp.get(startChar) + 1); // Increase frequency in the map
                    if (mp.get(startChar) > 0) {
                        reqcount++; // Increase required count
                    }
                }
                i++; // Shrink the window
            }
            j++; // Expand the window
        }
        
        return minwindowsize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minwindowsize); // Return result
    }
}
