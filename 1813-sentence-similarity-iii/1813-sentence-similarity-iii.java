class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] word1 = sentence1.split(" ");
        String[] word2 = sentence2.split(" ");

        // Check Case... FOR SWITCHING
        if (word1.length > word2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i = 0;
        // scanning both the word from the STARTING...
        // if both are equal continue the process...
        while (i < word1.length && word1[i].equals(word2[i])) {
            i++;
        }

        // if above case isn't satisfied then....
        // start equating from the last of the "sentence2"(word2)
        // if matches continue...
        while (i < word1.length && word1[i].equals(word2[i + word2.length - word1.length])) {
            i++;
        }

        // whenever all the case are checked just compare the last one with word1.length
        return i == word1.length;
        
    }
}