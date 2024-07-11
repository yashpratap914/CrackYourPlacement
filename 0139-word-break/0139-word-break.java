class Solution {
    Set<String> dictionary;
    Map<String, Boolean> memo;
    
    public boolean wordBreakUtil(String s, String cur, int index) {
        
        String key = cur + "_" + index; // this will always form a unique key, eg. cur = leet, index = 4, then key = leet_4;
        
        if (memo.containsKey(key)) return memo.get(key); // if already memoized then simply returning
        
        // checking base condition
        if (index == s.length()) {
            return dictionary.contains(cur);
        }
        
        char c = s.charAt(index);

		/* 1 */
        if (dictionary.contains(cur)) {
            if (wordBreakUtil(s, "" + c, index+1)) {
                memo.put(key, true);
                return true;
            }
        }
        
		/* 2 */
        memo.put(key, wordBreakUtil(s, cur + c, index+1));
        return memo.get(key);
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        dictionary = new HashSet<>();
        memo = new HashMap<>();
        
        for (String word : wordDict) dictionary.add(word);
        
        return wordBreakUtil(s, "", 0);
    }
}