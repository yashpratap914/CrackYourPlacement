class Solution {
    public int minSteps(String s, String t) {
        // Create a map to store the frequency of characters in string s
        Map<Character, Integer> freqMap = new HashMap<>();
        
        // Iterate through string s and update the frequency map
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int steps = 0;
        
        // Iterate through string t and decrement the frequency of characters in the map
        // If a character is not present in the map or its frequency becomes negative, increment the steps
        for (char c : t.toCharArray()) {
            if (freqMap.containsKey(c) && freqMap.get(c) > 0) {
                freqMap.put(c, freqMap.get(c) - 1);
            } else {
                steps++;
            }
        }
        
        return steps;
        
    }
}