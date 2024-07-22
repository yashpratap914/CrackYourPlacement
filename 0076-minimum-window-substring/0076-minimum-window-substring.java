import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        String ans = "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int i = 0, j = 0; // Window pointers
        int required = tMap.size(); // Number of unique characters in t to match
        int formed = 0; // Number of unique characters matched in the current window
        int[] ansLength = {Integer.MAX_VALUE, 0, 0}; // Length of window, left, right

        while (j < s.length()) {
            char ch = s.charAt(j);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // Check if the current character's frequency matches with the target frequency
            if (tMap.containsKey(ch) && windowMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                formed++;
            }

            // Try to contract the window until the point it ceases to be 'desirable'
            while (i <= j && formed == required) {
                ch = s.charAt(i);

                // Update the answer if this window is smaller
                if (j - i + 1 < ansLength[0]) {
                    ansLength[0] = j - i + 1;
                    ansLength[1] = i;
                    ansLength[2] = j;
                }

                // The character at the position pointed by `i` is no longer a part of the window
                windowMap.put(ch, windowMap.get(ch) - 1);
                if (tMap.containsKey(ch) && windowMap.get(ch).intValue() < tMap.get(ch).intValue()) {
                    formed--;
                }

                i++;
            }

            // Keep expanding the window
            j++;
        }

        return ansLength[0] == Integer.MAX_VALUE ? "" : s.substring(ansLength[1], ansLength[2] + 1);
    }
}
