import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        int totalLength = m * n;

        if (s.length() < totalLength) {
            return ans;
        }

        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int left = i;
            int count = 0;
            HashMap<String, Integer> seen = new HashMap<>();

            for (int j = i; j <= s.length() - m; j += m) {
                String word = s.substring(j, j + m);
                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + m);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += m;
                        count--;
                    }

                    if (count == n) {
                        ans.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = j + m;
                }
            }
        }
        return ans;
    }
}
