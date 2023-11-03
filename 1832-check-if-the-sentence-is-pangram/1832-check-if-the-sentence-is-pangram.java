class Solution {
    public boolean checkIfPangram(String sentence) {
         // Create a boolean array to keep track of the presence of each letter
        boolean[] letters = new boolean[26];
        
        // Iterate through each character in the sentence
        for (char c : sentence.toCharArray()) {
            // If the character is a lowercase letter, mark it as present in the array
            if (Character.isLetter(c)) {
                letters[c - 'a'] = true;
            }
        }
        
        // Check if all letters are present in the array
        for (boolean letter : letters) {
            if (!letter) {
                return false;
            }
        }
        
        return true;
        
    }
}