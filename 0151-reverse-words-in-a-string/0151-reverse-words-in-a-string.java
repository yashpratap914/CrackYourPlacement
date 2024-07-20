class Solution {
    // Define the method to reverse the order of words in a string
    public String reverseWords(String s) { 
        // Split the input string 's' into words based on one or more spaces.
        // The split() method uses a regular expression " +" which matches one or more spaces.
        String[] words = s.split(" +");
        
        // Create a StringBuilder object to build the reversed string efficiently.
        StringBuilder sb = new StringBuilder();
        
        // Iterate over the words array from the last word to the first.
        for(int i = words.length - 1; i >= 0; i--){
            // Append the current word to the StringBuilder.
            sb.append(words[i]);
            // Append a space after the word. This ensures words are separated by a single space in the final output.
            sb.append(" ");
        }
        
        // Convert the StringBuilder object to a String and remove any trailing spaces.
        // The trim() method is used to remove the extra space added at the end of the reversed sentence.
        return sb.toString().trim();
    }
}
