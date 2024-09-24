class TrieNode {
    TrieNode[] children = new TrieNode[10];
}

class Trie {
    TrieNode root = new TrieNode();
       void insert(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);
        for (char ch : numStr.toCharArray()) {
            int i = ch - '0';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
    }


    int findLongestPrefix(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);
        int maxLen = 0;

        for (char ch : numStr.toCharArray()) {
            int i = ch - '0';
            if (node.children[i] != null) {
                maxLen++;
                node = node.children[i];
            } else {
                break;
            }
        }
        return maxLen;
    }
}

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int num : arr1) {
            root.insert(num);
        }

        int longest = 0;
        for (int num : arr2) {
            int maxLen = root.findLongestPrefix(num);
            longest = Math.max(longest, maxLen);
        }

        return longest;
    }
}