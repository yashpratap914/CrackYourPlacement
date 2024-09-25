class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        int count; // keeps track of how many words share this prefix
        
        TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
            currentNode.count++;  // increase the prefix count
        }
    }

    private int getScore(TrieNode root, String word) {
        TrieNode currentNode = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.children.get(c);
            score += currentNode.count;
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        
        // Step 1: Insert all words into the Trie
        for (String word : words) {
            insert(root, word);
        }
        
        // Step 2: Calculate the score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getScore(root, words[i]);
        }
        
        return result;
    }
}